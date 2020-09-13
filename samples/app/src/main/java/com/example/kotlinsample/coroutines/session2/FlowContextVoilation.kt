package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//Flows are cold
fun simple111(): Flow<Int> = flow {
    println("Flow started " + Thread.currentThread().name)
    withContext(IO) {
        for (i in 1..3) {
            delay(2000)
            println("emit $i")
            emit(i)
        }
    }
}

fun main() = runBlocking<Unit> {

    println("Calling simple function..." + Thread.currentThread().name)
    val flow = simple111()

//    launch {
//        println("A Calling collect...")
//        withContext(IO) {
//            flow.collect { value -> println("A collected $value") }
//        }
//    }

    launch {
        println("B Calling collect again...")
        flow.collect { value -> println("B collected $value") }
    }

}