package chapter4

class User private constructor(val nickname: String){
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))
        //fun newFacebookUser(accountId: Int) = User(getFacebookName(accountId))
    }
//    val nickname: String
//
//    constructor(email: String) {
//        nickname = email.subSequence('@')
//    }
//
//    constructor(facebookAccountId: Int) {
//        nickname = getFacebookName(facebookAccountId)
//    }
}

//class User(val name: String){
//    var address: String = "unspecified"
//    set(value: String) {
//        println("""
//            Address was changed for $name:
//            "$field" -> "$value".""".trimIndent())
//        field = value
//    }
//}

//interface User {
//    val email: String
//    val nickname: String
//    get() = email.substringBefore('@')
//}