package by.siegell.caliper.domain

/**
 * Информация о параметре функции.
 *
 * @property name Название параметра
 * @property type Тип параметра
 */
data class CaliperParameterInfo(
    val name: String,
    val type: CaliperType
)