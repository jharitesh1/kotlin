package com.example.kotlinsample.coroutines.session2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

//reduce operator is used to collect the Flow. Reduce will collect two inputs at a time

fun main() = runBlocking<Unit> {
    val sum = (1..3).asFlow()
        .map {
            println("start map : " + it)
            it * it
        } // squares of numbers from 1 to 5
        .reduce { a, b ->
            println("start reduce a : b : " + a + " : " + b + "--sum : " + (a + b))
            a + b
        }

    println(" print sum : " + sum)
}