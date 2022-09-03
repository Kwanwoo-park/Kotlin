package chapter10

import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor

class ClassInfo<T: Any>(cls: KClass<T>) {
    private val constructor = cls.primaryConstructor!!
    private val jsonNameToParam = hashMapOf<String, KParameter>()
    private val paramToSerializer = hashMapOf<KParameter, ValueSerializer<out Any?>>()
    private val jsonNameToDeserializeClass = hashMapOf<String, Class<out Any>?>()

    init {
        constructor.parameters.forEach { cacheDataForParameter(cls, it) }
    }

    fun getConstructorParameter(propertyName: String): KParameter =
        jsonNameToParam[propertyName]!!

    fun deserializeConstructorArgument(param: KParameter, value: Any?): Any? {
        val serializer = paramToSerializer[param]
        if (serializer != null) return serializer.fromJsonValue(value)
        validateArgumentType(param, value)
        return value
    }

    fun createInstance(argument:Map<KParameter, Any?>): T {
        ensureAllParametersPresent(argument)
        return constructor.callBy(argument)
    }

    fun ensureAllParametersPresent(argument: Map<KParameter, Any?>) {
        for (param in constructor.parameters) {
            if (argument[param] == null && !param.isOptional && !param.type.isMarkedNullable)
                        throw JKidException("Missing value for parameter ${param.name}"){

            }
        }
    }
}