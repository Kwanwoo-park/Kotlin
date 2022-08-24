package chapter4

import java.io.File

//class PrivateUser(override val nickname: String): User
//class SubscribingUser(val email: String): User {
//    override val nickname: String
//    get() = email.substringBefore('@')
//}
//class FacebookUser(val accountId: Int): User {
//    override val nickname = getFacebookName(accountId)
//}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun main(args: Array<String>) {
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    println(subscribingUser.nickname)
    //A.bar()
//    val persons = listOf(Person("Bob"), Person("Alice"))
//    println(persons.sortedWith(Person.NameComparator))
//    val files = listOf(File("/z"), File("/a"))
//    println(files.sortedWith(CaseInsensitiveFileComparator))
//    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
//    val cset = CountingSet<Int>()
//    cset.addAll(listOf(1, 1, 2))
//    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
//    val lee = Client("이계영", 4122)
//    println(lee.copy(postalCode = 4000))
//    val processed = hashSetOf(Client("오현석", 4122))
//    println(processed.contains(Client("오현석", 4122)))
//    val client1 = Client("오현석", 4122)
//    val client2 = Client("오현석", 4122)
//    println(client1 == client2)
//    val lengthCounter = LengthCounter()
//    lengthCounter.addWord("Hi!")
//    println(lengthCounter.counter)
//    val user = User("Alice")
//    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
//    println(PrivateUser("test@kotlinlang.org").nickname)
//    println(SubscribingUser("test@kotlinlang.org").nickname)
//    val button = Button()
//    button.showOff()
//    button.setFocus(true)
//    button.click()
    //Button().click()
}