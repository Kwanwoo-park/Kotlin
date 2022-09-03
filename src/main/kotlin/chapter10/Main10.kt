package chapter10

import java.io.Reader
import java.lang.reflect.Type
import javax.swing.text.html.parser.Parser
import kotlin.reflect.*
import kotlin.reflect.full.*

var counter = 0

fun main(args: Array<String>) {
//    val json = """{"title": "catch-22", "author": {"name": "J.Heller"}}"""
//    val book = deserialize<Book>(json)
//    println(book)
//    val person = Person("Alice", 29)
//    val memberProperty = Person::age
//    println(memberProperty.get(person))
//    val kProperty = ::counter
//    kProperty.setter.call(21)
//    println(kProperty.get())
//    val kFunction: KFunction2<Int, Int, Int> = ::sum
//    println(kFunction.invoke(1, 2) + kFunction(3, 4))
//    kFunction(1)
//    val kFunction = ::foo
//    kFunction.call(42)
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
//    println(kClass.simpleName)
//    kClass.memberProperties.forEach { println(it.name) }
    kClass.memberProperties.filter { it.findAnnotation<JsonExclude>() == null }
}

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

//private fun StringBuilder.serializeObject(obj: Any) {
//    val kClass = obj.javaClass.kotlin
//    val properties = kClass.memberProperties
//
//    properties.joinToStringBuilder(this, prefix = "{", postfix = "}") { prop ->
//        serializeString(prop.name)
//        append(": ")
//        serializePropertyValue(prop.get(obj))
//    }
//}

//fun serialize(obj: Any): String = buildString { serializeObject(obj) }

inline fun <reified T> KAnnotatedElement.findAnnotation(): T? = annotations.filterIsInstance<T>().firstOrNull()

//inline fun <reified T: Any> deserialize(json: String): T

//private fun StringBuilder.serializeObject(obj: Any) {
//    obj.javaClass.kotlin.memberProperties
//        .filter { it.findAnnotation<JsonExclude>() == null }
//        .joinToStringBuilder(this, prefix = "{", postfix = "}") {
//            serializeProperty(it, obj)
//        }
//}

//private fun StringBuilder.serializeProperty(prop: KProperty1<Any, *>, obj: Any) {
//    val jsonNameAnn = prop.findAnnotation<JsonName>()
//    val propName = jsonNameAnn?.name ?: prop.name
//    serializeString(propName)
//    append(": ")
//    serializeProperty(prop.get(obj))
//}

//private fun StringBuilder.serializeProperty(prop: KProperty1<Any, *>, obj: Any) {
//    val name = prop.findAnnotation<JsonName>()?.name ?: prop.name
//    serializeString(name)
//    append(": ")
//
//    val value = prop.get(obj)
//    val jsonValue = prop.getSerializer()?.fromJsonValue(value) ?: value
//    serializePropertyValue(jsonValue)
//}

fun KProperty<*>.getSerializer(): ValueSerializer<Any?>? {
    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
    val serializerClass = customSerializerAnn.serializerClass
    val valueSerializer = serializerClass.objectInstance ?: serializerClass.createInstance()
    @Suppress("UNCHECKED_CAST")
    return valueSerializer as ValueSerializer<Any?>
}

fun <T: Any> deserialize(json: Reader, targetClass: KClass<T>): T {
    val seed = ObjectSeed(targetClass, ClassInfoCache())
    Parser(json, seed).parse()
    return seed.spawn()
}

fun serializerForType(type: Type): ValueSerializer<out Any?>? =
    when(type) {
        Byte::class.java -> ByteSerializer
        Int::class.java -> IntSerializer
        Boolean::class.java -> BooleanSerializer
        //...
        else -> null
    }