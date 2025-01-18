package by.siegell.caliper.processor

import by.siegell.caliper.parser.Parser
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class CaliperProcessorProvider: SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        val parser = Parser()
        return CaliperProcessor(environment, parser)
    }
}