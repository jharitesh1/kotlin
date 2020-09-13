package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Flows are cold
fun simple1(): Flow<Int> = flow {
    println("Flow started " + Thread.currentThread().name)
    for (i in 1..3) {
        delay(2000)
        print("emit $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function..." + Thread.currentThread().name)
    val flow = simple1()

    launch {
        println("1 Calling collect........................")
        flow.collect { value -> println("collect $value") }
    }

    launch {
        println("2 Calling collect again......................")
        flow.collect { value -> println("collect $value") }
    }

}