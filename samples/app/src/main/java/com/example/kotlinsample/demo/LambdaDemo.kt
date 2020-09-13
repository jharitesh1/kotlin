package com.example.kotlinsample.demo

fun main() {

}

suspend fun processFruits() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map {
            it.toUpperCase()
            println("--->" + Thread.currentThread().name + " : " + it.toString())
        }
        .forEach { println(it) }
}