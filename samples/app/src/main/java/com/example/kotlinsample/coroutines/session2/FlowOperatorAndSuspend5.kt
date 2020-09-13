package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Flows are cold.
//Map & filter can be used to do some alteration before receiving the data by Collect.
//suspend can be used with this operators

suspend fun simple3(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        println("emitted $i : " + Thread.currentThread().name)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function...")
    val flow = simple3()

    launch {
        println("Calling collect...")
        flow
            .filter { t -> t == 2 }
            .map { t -> perform(t) }
            .collect { t -> println(t) }
    }
}

private suspend fun perform(num: Int): String {
    delay(1000)
    return "processed $num"
}
