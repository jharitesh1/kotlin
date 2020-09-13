package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


//Conflation
//When a flow represents partial results of the operation or operation status updates,
// it may not be necessary to process each value, but instead, only most recent ones.

//Conflation is one way to speed up processing when both the emitter and collector are slow.
// It does it by dropping emitted values.
fun simple441(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..5) {
        delay(1000)
        println("emitted $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("This will collect the latest and greatest elements...")
    val flow = simple441()
    val time1 = measureTimeMillis {
        flow
            .conflate() //conflate emissions, don't process each one
            .collect { value ->
            println("conflate $value")
            delay(2500)
            println(value)
        }
    }
    println("Time spent for 1st collect function : " + time1)
}