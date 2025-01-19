package by.siegell.caliper.reporter.mapper

import by.siegell.caliper.domain.CaliperFunctionInfo
import by.siegell.caliper.domain.CaliperParameterInfo
import by.siegell.caliper.domain.CaliperPropertyInfo
import by.siegell.caliper.domain.CaliperType

interface Mapper {
    fun asString(property: CaliperPropertyInfo): String

    fun asString(function: CaliperFunctionInfo): String

    fun asString(parameter: CaliperParameterInfo): String

    fun asString(type: CaliperType): String
}