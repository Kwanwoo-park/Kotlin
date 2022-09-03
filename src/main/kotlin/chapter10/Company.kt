package chapter10

import java.util.*

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String): Company

//data class Person2(
//    val name: String,
//    @DeserializeInterface(CompanyImpl::class) val company: Company
//)

data class Person2(
    val name: String,
    @CustomSerializer(DateSerializer::class) val birthDate: Date
)