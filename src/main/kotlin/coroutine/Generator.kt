package coroutine

import kotlin.coroutines.RestrictsSuspension
import kotlin.coroutines.startCoroutine

interface Generator<out R, in T> {
    fun next(param: T): R?
}

@RestrictsSuspension
interface GeneratorBuilder<in T, R> {
    suspend fun yield(value: T): R
    suspend fun yieldAll(generator: Generator<T, R>, param:R)
}

fun <T, R> generate(block: suspend GeneratorBuilder<T, R>.(R) -> Unit): Generator<T, R> {
    val coroutine = GeneratorCoroutine<T, R>()
    val initial: suspend (R) -> Unit = {result -> block(coroutine, result)}
    coroutine.nextStep = {param -> initial.startCoroutine(param, coroutine)}
    return coroutine
}