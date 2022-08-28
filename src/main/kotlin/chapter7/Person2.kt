package chapter7

class Person2 {
    private val _attribute = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attribute[attrName] = value
    }

    val name: String by _attribute

//    val name: String
//    get() = _attribute["name"]!!
}