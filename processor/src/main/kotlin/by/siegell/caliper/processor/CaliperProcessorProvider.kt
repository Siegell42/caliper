package by.siegell.caliper.processor

import by.siegell.caliper.parser.Parser
import by.siegell.caliper.reporter.MarkdownReporter
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class CaliperProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        val parser = Parser()
        val reporter = MarkdownReporter()
        return CaliperProcessor(environment, parser, reporter)
    }
}