package chapter9

import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator: FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator: FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

object Validators {
    private val validator = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(
        kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validator[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T: Any> get(kClass: KClass<T>): FieldValidator<T> =
        validator[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}