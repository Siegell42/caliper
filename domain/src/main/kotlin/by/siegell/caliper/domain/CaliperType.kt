package by.siegell.caliper.domain

/**
 * Модель для представления типа.
 * Можно расширять: добавлять информацию о вариации, nullable и т.д.
 *
 * @property rawName Имя типа, прим.: [Boolean], [Map], [List]
 * @property typeArguments параметры (при наличии)
 * @property isStarProjection используется ли "star" проекция типа
 * @property variance вариантность, "out", "in" или null, если инвариант
 */
data class CaliperType(
    val rawName: String,
    val typeArguments: List<CaliperType>, // вложенные CaliperType
    val isStarProjection: Boolean = false,
    val variance: String? = null    // "out", "in" или null, если invariant
)