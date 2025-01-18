package by.siegell.caliper.parser

import by.siegell.caliper.domain.CaliperClassInfo
import by.siegell.caliper.domain.CaliperFunctionInfo
import by.siegell.caliper.domain.CaliperParameterInfo
import by.siegell.caliper.domain.CaliperPropertyInfo
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
            type = type.asString()
        )
    }

    private fun analyzeFunction(ksFunction: KSFunctionDeclaration) = with(ksFunction) {
        CaliperFunctionInfo(
            name = simpleName.asString(),
            parameters = parameters.map { analyzeParameter(it) },
            returnType = returnType.asString(),
            body = null
        )
    }

    private fun analyzeParameter(ksValueParameter: KSValueParameter) = with(ksValueParameter) {
        CaliperParameterInfo(
            name = name?.asString().orEmpty(),
            type = type.asString()
        )
    }

    private fun KSTypeReference?.asString(): String = this?.resolve()?.declaration?.qualifiedName?.asString().orEmpty()
}