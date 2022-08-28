package chapter7

import java.beans.PropertyChangeListener
import java.math.BigDecimal
import java.time.LocalDate

fun main(args: Array<String>) {
    val p = Person2()
    val data = mapOf("name" to "Dmitry", "companty" to "JetBrains")
    for ((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }
    println(p.name)
//    val p = Person("Dmitry", 34, 2000)
//    p.addPropertyChangeListener(
//        PropertyChangeListener { event ->
//            println("Propertry ${event.propertyName} changed " +
//            "from ${event.oldValue} to ${event.newValue}")
//        }
//    )
//    p.age = 35
//    p.salary = 2300
//    val p = Person("Alice")
//    p.emails
//    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
//    printEntries(map)
//    val (name, ext) = splitFilename("example.kt")
//    println("name:$name\next:$ext")
//    val p = Point(10, 20)
//    val (x, y) = p
//    println(x)
//    println(y)
//    val newYear = LocalDate.ofYearDay(2017, 1)
//    val daysOff = newYear.minusDays(1)..newYear
//    for (dayOff in daysOff) {println(dayOff)}
//    val n = 9
//    println(0..(n+1))
//    (0..n).forEach { print(it)}
//    val now = LocalDate.now()
//    val vacation = now..now.plusDays(10)
//    println(now.plusWeeks(1) in vacation)
//    val rect = Rectangle(Point(10, 20), Point(50, 50))
//    println(Point(20, 30) in rect)
//    println(Point(5, 5) in rect)
//    val p = MutablePoint(10, 20)
//    p[1] = 42
//    println(p)
//    val p = Point(10, 20)
//    println(p[1])
//    val p1 = Person("Alice", "Smith")
//    val p2 = Person("Bob", "Johnson")
//    println(p1 < p2)
//    println(Point(10, 20) == Point(10, 20))
//    println(Point(10, 20) != Point(5, 5))
//    println(null == Point(1, 2))
//    var bd = BigDecimal.ZERO
//    println(bd++)
//    println(++bd)
//    val p = Point(10, 20)
//    println(-p)
//    val list = arrayListOf(1, 2)
//    list += 3
//    val newList = list + listOf(4, 5)
//    println(list)
//    println(newList)
//    val numbers = ArrayList<Int>()
//    numbers += 42
//    println(numbers[0])
//    var point = Point(1, 2)
//    point += Point(3, 4)
//    println(point)
   // println('a' * 3)
//    val p = Point(10, 20)
//    println(p * 1.5)
//    val p1 = Point(10, 20)
//    val p2 = Point(30, 40)
//    println(p1 + p2)
}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IllegalArgumentException("Invalid coordinate $index")
    }
}

//operator fun <T: Comparable<T>> T.rangeTo(that: T): ClosedRange<T>

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object: Iterator<LocalDate> {
        var current = start

        override fun hasNext() =
            current <= endInclusive

        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}