package chapter5

import java.io.File
import java.lang.StringBuilder

fun main(args: Array<String>) {
    println(alphabet())
//    createAllDoneRunnable().run()
//    val file = File("/Users/svtk/.HiddenDir/a.txt")
//    println(file.isInsideHiddenDirectory())
//    val naturalNumbers = generateSequence(0) { it + 1}
//    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
//    println(numbersTo100.sum())
//    println(listOf(1, 2, 3, 4).asSequence()
//        .map { it * it }.find { it > 3 })
//    println(listOf(1, 2,3, 4).asSequence()
//        .map { print("map($it) "); it * it }
//        .filter { print("filter($it) "); it % 2 == 0 }
//        .toList())
//    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
//                        Book("Mort", listOf("Terry Pratchett")),
//                        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
//    )
//    println(books.flatMap { it.authors }.toSet())
//    val people = listOf(Person("Alice", 31),
//                        Person("Bob", 29), Person("Carol", 31)
//    )
//    println(people.groupBy { it.age })
//    val canBeInClub27 = {p: Person -> p.age <= 27}
//    val people = listOf(Person("Alice", 27), Person("Bob", 31))
//    println(people.all(canBeInClub27))
//    println(people.any(canBeInClub27))
//    val numbers = mapOf(0 to "Zero", 1 to "One")
//    println(numbers.mapValues { it.value.toUpperCase() })
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    val maxAge = people.maxBy(Person::age)!!.age
//    println(people.filter { it.age == maxAge })
//    println(people.filter { it.age > 30 }.map ( Person::name ))
//    println(people.filter { it.age == people.maxBy(Person::age) !!.age })
//    println(people.map(Person::name))
//    val list = listOf(1, 2, 3, 4)
//    println(list.map { it * it })
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    println(people.filter { it.age > 30 })
//    val list = listOf(1, 2, 3, 4)
//    println(list.filter { it % 2 == 0 })
//    val createPerson = ::Person
//    val p = createPerson("Alice", 29)
//    println(p)
//    val response = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
//    printProblemCounts(response)
//    val errors = listOf("403 Forbidden", "404 Not Found")
//    printMessageWithPrefix(errors, "Error:")
//    val sum = {x: Int, y: Int ->
//        println("Computing the sum of $x and $y...")
//        x + y
//    }
//    println(sum(1, 2))
//    val people = listOf(Person("이몽룡", 29), Person("성춘향", 31))
//    val getAge = {p: Person -> p.age}
//    people.maxBy(getAge)
//    val people = listOf(Person("이몽룡", 29), Person("성춘향", 31))
//    val names = people.joinToString(separator = " ",
//                                    transform = {p: Person -> p.name})
//    println(names)
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    people.maxBy({p: Person -> p.age})
//    val sum = {x: Int, y: Int -> x+y}
//    println(sum(1, 2))
//    { println(42)} ()
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    findTheOldest(people)
//    println(people.maxBy { it.age })
}

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    println(theOldest)
}

fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach{
        println("$prefix $it")
    }
}

fun printProblemCounts(response: Collection<String>) {
    var clientError = 0
    var serverError = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientError++
        }
        else if (it.startsWith("5")) {
            serverError++
        }
    }
    println("$clientError client errors, $serverError server errors")
}

fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile}.any { it.isHidden }

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}

//fun alphabet(): String {
//    val stringBuilder = StringBuilder()
//    return with(stringBuilder) {
//        for (letter in 'A'..'Z') {
//            this.append(letter)
//        }
//        append("\nNow I knwo the alphabet")
//        this.toString()
//    }
////    val result = StringBuilder()
////    for (letter in 'A'..'Z') {
////        result.append(letter)
////    }
////
////    result.append("\nNow I know the alphabet!")
////    return result.toString()
//}

//fun alphabet() = with(StringBuilder()) {
//    for (letter in 'A'..'Z') {
//        append(letter)
//    }
//
//    append("\nNow I know the alphabet!")
//    toString()
//}

//fun alphabet() = StringBuilder().apply {
//    for (letter in 'A'..'Z') {
//        append(letter)
//    }
//
//    append("\nNow I know the alphabet!")
//}.toString()

fun alphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }

    append("\nNow I know the alphabet!")
}