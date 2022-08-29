package chapter8

data class Person2(val name: String, val age: Int)

val people = listOf(Person2("Alice", 29), Person2("Bob", 31))

fun lookForAlice(people: List<Person2>) {
    people.forEach (fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })

//    people.forEach {
//        if (it.name == "Alice") return@forEach
//    }
//
//    println("Alice might be somewhere")

//    people.forEach label@{
//        if (it.name == "Alice") return@label
//    }
//
//    println("Alice might be somewhere")

//    people.forEach {
//        if (it.name == "Alice") {
//            println("Found!")
//            return
//        }
//    }
//
//    println("Alice is not found")

//    for (person in people) {
//        if (person.name == "Alice") {
//            println("Found!")
//            return
//        }
//    }
//
//    println("Alice is not found")
}