package by.siegell.caliper.reporter.section

import by.siegell.caliper.domain.CaliperClassInfo
import by.siegell.caliper.reporter.mapper.Mapper

abstract class Section(
    protected val mapper: Mapper
) {

    abstract fun append(builder: StringBuilder, classInfo: CaliperClassInfo): StringBuilder
}