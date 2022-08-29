package chapter8

import java.lang.StringBuilder
import java.util.concurrent.locks.Lock

val averageWindowsDuration = log
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()

val averageMobileDuration = log
    .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
    .map(SiteVisit::duration)
    .average()

fun main(args: Array<String>) {
    people.filter(fun (person): Boolean {
        return person.age < 30
    })
    people.filter(fun (person) = person.age < 30)
    //lookForAlice(people)
    //println(averageWindowsDuration)
//    println(log.averageDurationFor {
//        it.os in setOf(OS.ANDROID, OS.IOS)
//    })
//
//    println(log.averageDurationFor {
//        it.os == OS.IOS && it.path == "/signup"
//    })
    //println(averageMobileDuration)
//    println(log.averageDurationFor(OS.WINDOWS))
//    println(log.averageDurationFor(OS.MAC))
//    val averageWindowsDuration = log
//        .filter { it.os == OS.WINDOWS }
//        .map(SiteVisit::duration)
//        .average()
//
//    println(averageWindowsDuration)
//    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"),
//                        Person("Svetlana", "Isakova", null)
//    )
//    val contactListFilters = ContactListFilters()
//    with(contactListFilters) {
//        prefix = "Dm"
//        onlyWithPhoneNumber = true
//    }
//    println(contacts.filter(
//        contactListFilters.getPredicate()
//    ))
//    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
//    println("Shipping costs ${calculator(Order(3))}")
//    val letters = listOf("Alpha", "Beta")
//    println(letters.joinToString())
//    println(letters.joinToString { it.toLowerCase() })
//    println(letters.joinToString ( separator = "! ", postfix = "! ", transform = {it.toUpperCase()} ))
//    println("ab1c".filter { it in 'a'..'z' })
//    twoAndThree { a, b -> a + b }
//    twoAndThree { a, b -> a * b }
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }

    return sb.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String) ?= null
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element)?:element.toString()
        result.append(str)
    }

    result.append(postfix)

    return result.toString()
}

//fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}