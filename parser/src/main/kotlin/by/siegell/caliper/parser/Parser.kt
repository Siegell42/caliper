package by.siegell.caliper.parser

import by.siegell.caliper.domain.CaliperClassInfo
import by.siegell.caliper.domain.CaliperFunctionInfo
import by.siegell.caliper.domain.CaliperParameterInfo
import by.siegell.caliper.domain.CaliperPropertyInfo
import com.google.devtools.ksp.symbol.KSClassDeclaration

class Parser {

    fun analyzeClass(ksClass: KSClassDeclaration): CaliperClassInfo {
        return CaliperClassInfo(
            name = ksClass.simpleName.asString(),
            packageName = ksClass.packageName.asString(),
            properties = ksClass.getAllProperties()
                .map { property ->
                    CaliperPropertyInfo(
                        name = property.simpleName.asString(),
                        type = property.type.resolve().declaration.qualifiedName?.asString().orEmpty()
                    )
                }
                .toList(),
            functions = ksClass.getAllFunctions()
                .map { function ->
                    CaliperFunctionInfo(
                        name = function.simpleName.asString(),
                        parameters = function.parameters.map { parameter ->
                            CaliperParameterInfo(
                                name = parameter.name?.asString().orEmpty(),
                                type = parameter.type.resolve().declaration.qualifiedName?.asString().orEmpty()
                            )
                        },
                        returnType = function.returnType?.resolve()?.declaration?.qualifiedName?.asString().orEmpty(),
                        body = null
                    )
                }
                .toList()
        )
    }
}