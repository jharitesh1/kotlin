package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Flows are cold
// take operator will limit the size of emits so total n emits will be collected by collect operator when
// take(n) is used.

suspend fun simple5(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        println("emitted $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function...")
    val flow = simple5()


    val job = launch {
        println("Calling collect...")
        flow
            .transform { request ->
                println("transform started")
                if (request == 3) {
                    emit("1st Making request $request")
                    emit("2nd Making request $request")
                    emit("3rd Making request $request")
                } else {
                    emit("ignore $request")
                }
            }
            .take(3)
            .collect { t ->
                println("collect started - " + t)
            }
    }
}

private suspend fun perform(num: Int): String {
    delay(1000)
    return "processed $num"
}
