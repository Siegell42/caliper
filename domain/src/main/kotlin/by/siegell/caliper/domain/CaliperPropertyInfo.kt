package by.siegell.caliper.domain


/**
 * Информация о свойстве (поле) в Kotlin-классе.
 *
 * @property name Имя свойства
 * @property type Тип свойства
 */
data class CaliperPropertyInfo(
    val name: String,
    val type: CaliperType
)