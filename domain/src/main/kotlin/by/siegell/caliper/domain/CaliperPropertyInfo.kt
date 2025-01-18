package by.siegell.caliper.domain


/**
 * Информация о свойстве (поле) в Kotlin-классе.
 *
 * @property name Имя свойства
 * @property type Полный тип свойства (может включать generics, если нужно)
 */
data class CaliperPropertyInfo(
    val name: String,
    val type: String
)