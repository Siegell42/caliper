package by.siegell.caliper.domain

/**
 * Информация о функции (методе) в Kotlin-классе.
 *
 * @property name Название функции
 * @property parameters Список параметров функции
 * @property returnType Тип возвращаемого значения (может быть `null`, если это `Unit` или не установлен)
 * @property body Тело функции — может быть текстом или детальной структурой AST.
 *        Для MVP можно сохранить как строку, а при необходимости — разобрать глубже.
 */
data class CaliperFunctionInfo(
    val name: String,
    val parameters: List<CaliperParameterInfo>,
    val returnType: String?,
    val body: String?
)