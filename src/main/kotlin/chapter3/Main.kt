package chapter3

import java.lang.StringBuilder

var opCount = 0
const val UNIX_LINE_SEPARATOR = "\n"
val String.lastChar: Char
    get() = get(length - 1)
var StringBuilder.lastChar: Char
    get() = get(length -1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
    //parsePath("/User/yole/kotlin-book/chapter.adc")
//    println("Kotlin".lastChar)
//    val sb = StringBuilder("Kotlin?")
//    sb.lastChar = '!'
//    print(sb)
//    val view: View = Button()
//    view.click()
//    view.showOff()
//    val list = arrayListOf(1, 2, 3)
//    println(list.joinToString(" "))
//    println(listOf("one", "two", "eight").join(" "))
    //print(c)
    //println("Kotlin".lastChar())
//    val list = listOf(1, 2, 3)
//    println(joinToString(list, "; ", "(", ")"))
//    println(joinToString(list, ", ", "", ""))
//    println(joinToString(list))
//    println(joinToString(list, "; "))
}

fun String.lastChar() : Char = get(this.length - 1)

//fun <T> joinToString(collection: Collection<T>,
//                    separator: String,
//                    prefix: String,
//                    postfix: String): String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in collection.withIndex()) {
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//    result.append(postfix)
//    return result.toString()
//}

//fun <T> joinToString(collection: Collection<T>,
//                     separator: String = ", ",
//                     prefix: String = "",
//                     postfix: String = ""
//): String {
//    val result = StringBuilder(prefix)
//    for ((index, element) in collection.withIndex()) {
//        if (index > 0) result.append(separator)
//        result.append(element)
//    }
//    result.append(postfix)
//    return result.toString()
//}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex())  {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun performOperation() {
    opCount++
}

fun reportOperation() {
    println("Operation performed $opCount times")
}

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
//    val directory = path.substringBeforeLast("/")
//    val fullName = path.substringAfterLast("/")
//    val fileName = fullName.substringBeforeLast(".")
//    val extension = fullName.substringAfterLast(".")
//    println("Dir: $directory, name: $fileName, ext: $extension")
}