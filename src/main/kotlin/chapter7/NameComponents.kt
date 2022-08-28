package chapter7

data class NameComponents(val name: String, val extension: String)

//fun splitFilename(fullName: String): NameComponents {
//    val result = fullName.split('.', limit = 2)
//    return NameComponents(result[0], result[1])
//}

fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}