package by.siegell.caliper.reporter.section

import by.siegell.caliper.domain.CaliperClassInfo
import by.siegell.caliper.reporter.mapper.Mapper

class MermaidSection(
    mapper: Mapper
) : Section(mapper) {

    override fun append(builder: StringBuilder, classInfo: CaliperClassInfo) = builder.apply {
        appendLine("```mermaid")
        appendLine("classDiagram")
        appendLine("class ${classInfo.name} {")
        classInfo.properties.forEach {
            appendLine("  ${mapper.asString(it)}")
        }
        classInfo.functions.forEach {
            appendLine("  ${mapper.asString(it)}")
        }
        appendLine("}")
        appendLine("```\n")
    }
}