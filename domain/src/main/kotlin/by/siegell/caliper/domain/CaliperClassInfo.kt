package by.siegell.caliper.domain

/**
 * Информация о классе, аннотированном [CaliperTarget].
 *
 * Содержит базовую информацию (имя, пакет, свойства, функции), а в будущем
 * может дополняться сведениями об отношениях между классами и внутренними структурами (AST).
 *
 * @property name Имя класса (без учёта пакета)
 * @property packageName Имя пакета, в котором находится класс
 * @property properties Список свойств (полей) данного класса
 * @property functions Список функций (методов) данного класса
 */
data class CaliperClassInfo(
    val name: String,
    val packageName: String,
    val properties: List<CaliperPropertyInfo>,
    val functions: List<CaliperFunctionInfo>
)