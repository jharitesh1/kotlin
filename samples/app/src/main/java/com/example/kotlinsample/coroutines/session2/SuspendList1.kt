package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
When these values are computed by asynchronous code we can mark the simple function with a suspend modifier,
so that it can perform its work without blocking and return the result as a list:

The result will be a single output.
 */
suspend fun simpleFun(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking {
    simpleFun().forEach { value -> println(value) }
}