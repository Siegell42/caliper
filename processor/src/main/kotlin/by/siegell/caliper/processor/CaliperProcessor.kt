package by.siegell.caliper.processor

import by.siegell.caliper.parser.Parser
import by.siegell.caliper.reporter.MarkdownReporter
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import java.nio.file.Paths

class CaliperProcessor(
    private val environment: SymbolProcessorEnvironment,
    private val parser: Parser,
    private val reporter: MarkdownReporter
) : SymbolProcessor {

    private var isFirstRound = true

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (!isFirstRound) return emptyList()
        isFirstRound = false

        environment.logger.info("CaliperProcessor starting!")

        val oldReport = Paths.get("build/generated/ksp/main/resources/caliper/report.md").toFile()
        if (oldReport.exists()) oldReport.delete()

        environment.codeGenerator.createNewFile(
            dependencies = Dependencies(false),
            packageName = "caliper",
            fileName = "report",
            extensionName = "md"
        ).use { fileOutput ->
            val classes = resolver.getSymbolsWithAnnotation("by.siegell.caliper.domain.CaliperTarget")
                .filterIsInstance<KSClassDeclaration>()
                .map { parser.analyzeClass(it) }
                .toList()
            val reportContent = reporter.generateReport(classes)
            fileOutput.write(reportContent)
        }

        environment.logger.info("CaliperProcessor ended!")
        return emptyList()
    }
}