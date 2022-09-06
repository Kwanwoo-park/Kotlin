package coroutine

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

internal class GeneratorCoroutine<T, R>: Generator<T, R>, GeneratorBuilder<T, R> {
    lateinit var nextStep: (R) -> Unit
    private var lastValue: T? = null
    private var lastException: Throwable? = null

    override fun next(param: R): T? {
        nextStep(param)
        lastException?.let { throw it }
        return lastValue
    }

    override suspend fun yield(value: T): R = suspendCoroutineUninterceptedOrReturn {
        cont ->
        lastValue = value
        nextStep = {param -> cont.resume(param)}
        COROUTINE_SUSPEDED
    }

    override suspend fun yieldAll(generator: Generator<T, R>, param: R): Unit =
        suspendCoroutineUninterceptedOrReturn sc@ {
            cont ->
            lastValue = generator.next(param)
            if (lastValue == null) return@sc Unit
            nextStep = {
                param ->
                lastValue = generator.next(param)
                if (lastValue == null) cont.resume(Unit)
            }
            COROUTINE_SUSPEDED
        }

    override val context: CoroutineContext get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {
        result.onSuccess { lastValue = null }
            .onFailure { lastException = it }
    }
}