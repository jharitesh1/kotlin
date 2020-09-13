package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Flows are cold
// transform operator generalizes filter and map operators and can be used as a building block for other operators,
//can emits multiple times.

suspend fun simple4(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        println("emitted $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function...")
    val flow = simple4()


    val job = launch {
        println("Calling collect...")
        flow
            .transform { request ->
                println("transform started")
                if (request == 2) {
                    emit("1st Making request $request")
                    emit("2nd Making request $request")
                    emit(perform(request))
                } else {
                    emit("ignore $request")
                }
            }
            .collect { t ->
                println("collect started - " + t)
            }
    }
}

private suspend fun perform(num: Int): String {
    delay(1000)
    return "processed $num"
}
