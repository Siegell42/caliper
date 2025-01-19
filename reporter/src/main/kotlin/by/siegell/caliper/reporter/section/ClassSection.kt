package by.siegell.caliper.reporter.section

import by.siegell.caliper.domain.CaliperClassInfo
import by.siegell.caliper.reporter.mapper.Mapper

class ClassSection(
    mapper: Mapper
) : Section(mapper) {

    override fun append(builder: StringBuilder, classInfo: CaliperClassInfo): StringBuilder = builder.apply {
        appendLine("## ${classInfo.name}")
        appendLine("from package: ${classInfo.packageName}")
        appendLine("### properties")
        classInfo.properties.forEach {
            appendLine("- ${mapper.asString(it)}")
        }
        appendLine("### functions")
        classInfo.functions.forEach {
            appendLine("- ${mapper.asString(it)}")
        }
    }
}