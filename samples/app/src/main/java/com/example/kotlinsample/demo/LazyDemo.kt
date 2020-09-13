package com.example.kotlinsample.demo

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

val hello = fun() {
    println("ritesh hello fun")
}

fun hello1() {
    println("ritesh hello fun2")
}

fun main() {
    println(lazyValue)
    println(lazyValue)
    hello()
    hello1()
}