package chapter9

import kotlin.random.Random
import kotlin.reflect.KClass

fun main(args: Array<String>) {
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(42))
//    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
//    validators[String::class] = DefaultStringValidator
//    validators[Int::class] = DefaultIntValidator
//    val stringValidator = validators[String::class] as FieldValidator<String>
//    println(stringValidator.validate(""))
    //printFirst(listOf("Svetlana", "Dmitry"))
//    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
//    val chars = mutableListOf('a', 'b', 'c')
//    val unKnownElements: MutableList<*> = if (Random.nextBoolean()) list else chars
//    //unKnownElements.add(42)
//    println(unKnownElements.first())
//    val ints = mutableListOf(1,2,3)
//    val anyItems = mutableListOf<Any>()
//    copyData(ints, anyItems)
//    println(anyItems)
    //printContents(listOf("abc", "bac"))
//    val items = listOf("one", 2, "three")
//    println(items.filterIsInstance<String>())
//    println(isA<String>("abc"))
//    println(isA<String>(123))
    //printSum(listOf(1, 2, 3))
//    val helloWorld = StringBuilder("Hello World")
//    ensureTrailingPeriod(helloWorld)
//    println(helloWorld)
    //println(max("kotlin", "java"))
//    val letters = ('a'..'z').toList()
//    println(letters.slice<Char>(0..2))
//    println(letters.slice(10..13))
}

fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
    where T: CharSequence, T: Appendable {
        if (!seq.endsWith('.')) {
            seq.append('.')
        }
    }

//fun printSum(c: Collection<*>) {
//    val intList = c as? List<Int>
//        ?: throw IllegalArgumentException("List is expected")
//    println(intList.sum())
//}

fun printSum(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}

inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T>
        Iterable<*>.filterIsInstance(): List<T> {
    val destination = mutableListOf<T>()

    for (element in this) {
        if (element is T) {
            destination.add(element)
        }
    }

    return destination
}

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

//fun <T> copyData(source: MutableList<T>,
//                       destination: MutableList<T>) {
//    for (item in source) {
//        destination.add(item)
//    }
//}

//fun <T: R, R> copyData(source: MutableList<T>,
//                destination: MutableList<R>) {
//    for (item in source) {
//        destination.add(item)
//    }
//}

//fun <T> copyData(source: MutableList<out T>,
//                       destination: MutableList<T>) {
//    for (item in source) {
//        destination.add(item)
//    }
//}

fun <T> copyData(source: MutableList<T>,
                 destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

//fun printFirst(list: List<*>) {
//    if (list.isNotEmpty()) {
//        println(list.first())
//    }
//}

fun <T> printFirst(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}