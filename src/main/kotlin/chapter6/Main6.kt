package chapter6

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main(args: Array<String>) {
    val list = listOf("a", "b", "c")
    printInUppercase(list)
//    val source: Collection<Int> = arrayListOf(3, 5, 7)
//    val target: MutableCollection<Int> = arrayListOf(1)
//    copyElements(source, target)
//    println(target)
//    val reader = BufferedReader(StringReader("1\nabc\n42"))
//    val numbers = readNumbers(reader)
//    addValidNumbers(numbers)
    //fail("Error occurred")
//    println(Person3("Sam", 35).isOlderThan(Person3("Amy", 42)))
//    println(Person3("Sam", 35).isOlderThan(Person3("Jane")))
//    showProgress(146)
//    yellAtSafe(Person(null))
//    yellAt(Person(null))
    //printHashCode(null)
    //printHashCode(42)
//    verifyUserInput(" ")
//    verifyUserInput(null)
//    var email: String? = "yole@example.com"
//    email?.let { sendEmailTo(it) }
//    email = null
//    email?.let { sendEmailTo(it) }
    //ignoreNulls(null)
//    val p1 = Person2("Dmitry", "Jemerov")
//    val p2 = Person2("Dmitry", "Jemerov")
//    println(p1 == p2)
//    println(p1.equals(42))
//    val address = Address("Elsestr.47", 80687, "Munich", "Germany")
//    val jetbrains = Company("JetBrains", address)
//    val person = Person("Dmitry", jetbrains)
//    printShippingLabel(person)
//    printShippingLabel(Person("Alexey", null))
//    println(strLenSafe("abc"))
//    println(strLenSafe(null))
//    val person = Person("Dmitry", null)
//    println(person.countryName())
//    val ceo = Employee("Da Boss", null)
//    val developer = Employee("Bob Smith", ceo)
//    println(managerName(developer))
//    println(managerName(ceo))
//    printAllCaps("abc")
//    printAllCaps(null)
//    val x: String? = null
//    println(strLenSafe(x))
//    println(strLenSafe("abc"))
    //strLenSafe(null)
    //strLen(null)
}

fun strLen(s: String) = s.length
//fun strLenSafe(s: String?) = s.length
//fun strLenSafe(s: String?): Int =
//    if (s != null) s.length else 0

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

//fun <T> printHashCode(t: T) {
//    println(t?.hashCode())
//}

fun <T: Any> printHashCode(t: T) {
    println(t.hashCode())
}

fun yellAt(person: Person) {
    println(person.name.toUpperCase() + "!!!")
}

fun yellAtSafe(person: Person) {
    println((person.name ?: "Anyone").toUpperCase() + "!!!")
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent} % done!")
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        }
        catch (e: NumberFormatException) {
            result.add(null)
        }
    }

    return result
}

//fun addValidNumbers (numbers: List<Int?>) {
//    var sumOfValidNumbers = 0
//    var invalidNumbers = 0
//
//    for (number in numbers) {
//        if (number != null) {
//            sumOfValidNumbers += number
//        }
//        else {
//            invalidNumbers++
//        }
//    }
//    println("Sum of valid numbers: $sumOfValidNumbers")
//    println("Invalid numbers: $invalidNumbers")
//}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source)
        target.add(item)
}

fun printInUppercase(list: List<String>) {
    println(CollectionUtils.uppercaseAll(list))
    println(list.first())
}