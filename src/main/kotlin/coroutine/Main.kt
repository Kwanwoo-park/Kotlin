package coroutine

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit


fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()}:${Thread.currentThread()}: ${msg}")

fun launchInGlobalScope() {
    GlobalScope.launch {
        log("coroutine started")
    }
}

fun runBlockingExample() {
    runBlocking {
        launch {
            //log("GlobalScope.launch.started")
            log("coroutine started")
        }
    }
}

fun yieldExample() {
    runBlocking {
        launch {
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }
        log("after first launch")
        launch {
            log("2")
            yield()
            log("4")
            yield()
            log("6")
        }
        log("after second launch")
    }
    log("after runBlocking")
}

fun main() {
    sumAll()
//    log("main() started")
//    //launchInGlobalScope()
//    //runBlockingExample()
//    yieldExample()
//    log("yieldExample() executed")
//    Thread.sleep(5000L)
//    log("main() terminated")
}

//public fun CoroutineScope.launch(
//    context: CoroutineContext = EmptyCoroutineContext,
//    start: CoroutineStart = CoroutineStart.DEFAULT,
//    block: suspend CoroutineScope.() -> Unit
//): Job {
//    val newContext = newCoroutineContext(context)
//    val coroutine = if (start.isLazy)
//        LazyStandalonCoroutine(newContext, block) else
//            StandaloneCoroutine(newContext, active = true)
//    coroutine.start(start, coroutine, block)
//    return coroutine
//}
//
//public fun<T> CoroutineScope.async(
//    context: CoroutineContext = EmptyCoroutineContext,
//    start: CoroutineStart = CoroutineStart.DEFAULT,
//    block: suspend CoroutineScope.() -> T
//): Deferred<T> {
//    val newContext = newCoroutineContext(context)
//    val coroutine = if (start.isLazy)
//        LazyDeferredCoroutine(newContext, block) else
//            DeferredCoroutine<T>(newContext, active = true)
//    coroutine.start(start, coroutine, block)
//    return coroutine
//}

fun sumAll() {
    runBlocking {
        val d1 = async { delay(1000L); 1 }
        log("after async(d1)")
        val d2 = async { delay(2000L); 2 }
        log("after async(d2)")
        val d3 = async { delay(3000L); 3 }
        log("after async(d3)")

        log("1+2+3=${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}

suspend fun yieldThreeTimes() {
    log("1")
    delay(1000L)
    yield()
    log("2")
    delay(1000L)
    yield()
    log("3")
    delay(1000L)
    yield()
    log("4")
}

fun suspendExample() {
    GlobalScope.launch { yieldThreeTimes() }
}