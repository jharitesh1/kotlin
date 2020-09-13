package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//Flows are cold. Can't apply suspend on flow streams because it reacts when flow.collect is called.
fun simple44(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simple44()
    val time1 = measureTimeMillis {
        flow.collect { value ->
            delay(100)
            println(value)
        }
    }
    println("Time spent for 1st collect function : " + time1)

    val time2 = measureTimeMillis {
        flow.collect { value ->
            delay(100)
            println(value)
        }
    }
    println("Time spent for 2nd collect function : " + time2)

    val time3 = measureTimeMillis {
        flow.buffer().collect { value ->
            delay(100)
            println(value)
        }
    }
    println("Time spent for 3rd collect function [Buffer]: " + time3)
}