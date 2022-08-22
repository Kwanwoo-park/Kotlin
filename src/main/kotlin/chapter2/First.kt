package chapter2

import chapter2.Color
import chapter2.Color.*
import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("Not a number"))
    println(readNumber(reader))
//    println(isLetter('q'))
//    println(isNotDigit('x'))
//    println(recognize('8'))
//    val list = arrayListOf("10", "11", "1001")
//    for ((index, element) in list.withIndex()) {
//        println("$index = $element")
//    }
//    val binaryReps = TreeMap<Char, String>()
//
//    for (c in 'A'..'F') {
//        val binary = Integer.toBinaryString(c.toInt())
//        binaryReps[c] = binary
//    }
//
//    for ((letter, binary) in binaryReps) {
//        println("$letter = $binary")
//    }
//    for (i in 100 downTo 1 step 2) {
//        print(fizzBuzz(i))
//    }
//    for (i in 1..100) {
//        print(fizzBuzz(i))
//    }
    //println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
    //println(mixOptimized(BLUE, YELLOW))
    //println(mix(BLUE, YELLOW))
    //println(getWarmth(Color.ORANGE))
    //println(getMnemonic(Color.BLUE))
    //println(Color.BLUE.rgb())
    //println(createRandomRectangle().isSquare)
//    val rectangle = Rectangle(41, 43)
//    println(rectangle.isSquare)
//    val person = Person("Bob", true)
//    println(person.name)
//    println(person.isMarried)
    //println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
//    val name = if (args.size > 0) args[0] else "Kotlin"
//    println("Hello, $name")
//    println(max(1, 2))
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "vain"
    }

//fun getWarmth(color: Color) = when(color) {
//    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
//    Color.GREEN -> "neutral"
//    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
//}

fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == BLUE && c2 == YELLOW) || (c1 == YELLOW && c2 == BLUE) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }

//fun eval(e: Expr): Int {
//    if (e is Num) {
//        val n = e as Num
//        return n.value
//    }
//
//    if (e is Sum) {
//        return eval(e.right) + eval(e.left)
//    }
//
//    throw IllegalArgumentException("Unknown expression")
//}

//fun eval(e: Expr): Int = if (e is Num) {
//        e.value
//    } else if (e is Sum) {
//        eval(e.right) + eval(e.left)
//    } else {
//        throw IllegalArgumentException("Unknown expression")
//    }

//fun eval(e: Expr): Int = when(e) {
//    is Num -> e.value
//    is Sum -> eval(e.left) + eval(e.right)
//    else -> throw IllegalArgumentException("Unknown expression")
//}

fun evalWithLogging(e: Expr): Int = when (e) {
    is Num -> {
        println("num: ${e.value}")
        e.value
    }
    is Sum -> {
        val left = evalWithLogging(e.left)
        val right = evalWithLogging(e.right)
        println("sum: $left + $right")
        left + right
    }
    else -> throw IllegalArgumentException("Unknown expression")
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

//fun readNumber(reader: BufferedReader): Int? {
//    try {
//        val line = reader.readLine()
//        return Integer.parseInt(line)
//    }
//    catch (e: NumberFormatException) {
//        return null
//    }
//    finally {
//        reader.close()
//    }
//}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}