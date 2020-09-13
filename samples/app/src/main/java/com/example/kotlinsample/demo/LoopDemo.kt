package com.example.kotlinsample.demo

fun main() {

    for(i in 1 until 5 step 2) {
        println("-->$i")
    }

    for(i in 5 downTo -4 step 2) {
        println("<-- ($i)")
    }

    for(i in 5 until -4 step -2) {
        println("*** ($i)")
    }
}