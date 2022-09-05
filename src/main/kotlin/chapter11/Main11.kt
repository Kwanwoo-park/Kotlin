package chapter11


import kotlinx.html.stream.createHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr
import java.time.LocalDate
import java.time.Period
import kotlin.text.StringBuilder
import kotlin.time.days

val appendExcl: StringBuilder.() -> Unit = {this.append("!")}

fun main(args: Array<String>) {
//    val Int.days: Period
//        get() = Period.ofDays(this)
//    val Period.ago: LocalDate
//        get() = LocalDate.now() - this
//    val Period.fromNow: LocalDate
//        get() = LocalDate.now() + this
//    println(1.days.ago)
//    println(1.days.fromNow)
//    val dependencies = DependencyHandler()
//    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
//    dependencies {
//        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")
//    }
//    val i1 = Issue("IDEA-154446", "IDEA", "Bug",
//        "Major", "Save settings failed")
//    val i2 = Issue("KT-12183", "Kotlin", "Feature", "Normal",
//                "Intention: convert several calls on the same receiver to with/apply")
//    val predicate = ImportantIssuesPredicate("IDEA")
//    for (issue in listOf(i1, i2).filter(predicate)) {
//        println(issue.id)
//    }
//    val bavarianGreeter = Greeter("Servus")
//    bavarianGreeter("Dmitry")
    //println(createSimpleTable())
//    val map = mutableMapOf(1 to "one")
//    map.apply { this[2] = "two" }
//    with(map) { this[3] = "three" }
//    println(map)
//    val stringBuilder = StringBuilder("Hi")
//    stringBuilder.appendExcl()
//    println(stringBuilder)
//    println(buildString(appendExcl))
//    val s = buildString {
//        this.append("Hello, ")
//        append("World!")
//    }
//    val s = buildString {
//        it.append("Hello, ")
//        it.append("World!")
//    }
//    println(s)
}

//fun createSimpleTable() = createHTML().
//        table {
//            (this@table).tr {
//                (this@tr).td {
//                    +"cell"
//                }
//            }
//        }

//fun createSimpleTable() =
//    table {
//        tr {
//            td {
//
//            }
//        }
//    }
//
//fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

//fun buildString(
//    builderAction: (StringBuilder) -> Unit
//): String {
//    val sb = StringBuilder()
//    builderAction(sb)
//    return sb.toString()
//}

//fun buildString(
//    builderAction: StringBuilder.() -> Unit
//): String {
//    val sb = StringBuilder()
//    sb.builderAction()
//    return sb.toString()
//}

fun buildString(builderAction: StringBuilder.() -> Unit): String =
    StringBuilder().apply(builderAction).toString()

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)