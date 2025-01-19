package by.siegell.caliper.reporter.mapper

import by.siegell.caliper.domain.CaliperFunctionInfo
import by.siegell.caliper.domain.CaliperParameterInfo
import by.siegell.caliper.domain.CaliperPropertyInfo
import by.siegell.caliper.domain.CaliperType

class MermaidMapper : Mapper {

    override fun asString(property: CaliperPropertyInfo): String = with(property) {
        "+${asString(type)} $name"
    }

    override fun asString(function: CaliperFunctionInfo): String = with(function) {
        "+${
            name.replace(
                "[<>]".toRegex(),
                ""
            )
        }(${parameters.joinToString { asString(it) }}) ${asString(returnType)}"
    }

    override fun asString(parameter: CaliperParameterInfo): String = with(parameter) {
        "${asString(type)} $name"
    }

    override fun asString(type: CaliperType): String = with(type) {
        buildString {
            append(rawName)
            if (typeArguments.isNotEmpty()) append(
                typeArguments.joinToString(prefix = "~", postfix = "~") { asString(it) }
            )
        }
    }
}