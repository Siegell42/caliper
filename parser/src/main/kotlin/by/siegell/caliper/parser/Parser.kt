package by.siegell.caliper.parser

import by.siegell.caliper.domain.*
import com.google.devtools.ksp.symbol.*

class Parser {

    fun analyzeClass(ksClass: KSClassDeclaration) = with(ksClass) {
        CaliperClassInfo(
            name = simpleName.asString(),
            packageName = packageName.asString(),
            properties = getAllProperties()
                .map { analyzeProperty(it) }
                .toList(),
            functions = getAllFunctions()
                .map { analyzeFunction(it) }
                .toList()
        )
    }

    private fun analyzeProperty(ksProperty: KSPropertyDeclaration) = with(ksProperty) {
        CaliperPropertyInfo(
            name = simpleName.asString(),
            type = type.toCaliperType()
        )
    }

    private fun analyzeFunction(ksFunction: KSFunctionDeclaration) = with(ksFunction) {
        CaliperFunctionInfo(
            name = simpleName.asString(),
            parameters = parameters.map { analyzeParameter(it) },
            returnType = returnType.toCaliperType(),
            body = null
        )
    }

    private fun analyzeParameter(ksValueParameter: KSValueParameter) = with(ksValueParameter) {
        CaliperParameterInfo(
            name = name?.asString().orEmpty(),
            type = type.toCaliperType()
        )
    }

    private fun KSTypeReference?.toCaliperType(): CaliperType {
        if (this == null) {
            return CaliperType(
                rawName = "Unit",
                typeArguments = emptyList()
            )
        }

        val resolvedType = resolve()
        val declaration = resolvedType.declaration
        val rawName = declaration.simpleName.asString()

        val arguments = resolvedType.arguments.map { it.toCaliperType() }

        return CaliperType(
            rawName = rawName,
            typeArguments = arguments
            // variance и starProjection здесь тоже можно учесть
        )
    }

    private fun KSTypeArgument.toCaliperType(): CaliperType {
        if (variance == Variance.STAR || type == null) {
            return CaliperType("*", emptyList(), isStarProjection = true)
        }
        val varianceLabel = when (variance) {
            Variance.COVARIANT -> "out"
            Variance.CONTRAVARIANT -> "in"
            else -> null
        }
        val ref = type.toCaliperType()
        return ref.copy(variance = varianceLabel)
    }
}