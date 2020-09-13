package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


//Since the body of collectLatest takes 2500 ms, but new values are emitted every 100 ms,
// we see that the block is run on every value, but completes only for the last value:
// because when new value is collected then it will be restarted.

//Conflation is one way to speed up processing when both the emitter and collector are slow.It does it by dropping emitted values.
fun simple51(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..5) {
        delay(100)
        println("emitted  $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("This will collect the latest and greatest elements...")
    val flow = simple51()
    val time1 = measureTimeMillis {
        flow.collectLatest { value ->
            println("collectLatest start $value")
            delay(2500)
            println("collectLatest end $value")
        }
    }
    println("Time spent for 1st collect function : " + time1)
}