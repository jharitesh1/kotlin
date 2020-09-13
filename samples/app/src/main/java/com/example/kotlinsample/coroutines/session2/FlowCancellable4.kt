package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

//Flows are cold
fun simple2(): Flow<Int> = flow {
    println("Flow started : " + Thread.currentThread().name)
    for (i in 1..3) {
        delay(1000)
        println("emit $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function...")
    val flow = simple2()

    val job = withTimeoutOrNull(2500) {
        println("Calling collect...")
        flow.collect { value -> println("collect $value") }
    }

    if (job == null) {
        println("Job terminated...")
    }
}