package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

//Flows are cold. Can't apply suspend on flow streams because it reacts when flow.collect is called.
fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        println("Emit $i")
        emit(i) //already suspend
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    println("Calling collect...first...........")
    simple().collect { value ->
        delay(100)
        println("collect $value")
    }
    println("Calling collect again...second.........")
    simple().collect { value ->
        delay(100)
        println( "collect $value") } //collect is already suspend
}