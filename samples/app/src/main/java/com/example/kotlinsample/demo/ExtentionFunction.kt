package com.example.kotlinsample.demo

class ExampleExt {
    fun method1(str: String) {
        println("ExampleExt --> method1() : inside : " + str)
    }
}

fun ExampleExt.methodOutside() {
    method1("---> passed from outside")
    println("ExampleExt.methodOutside()")
}

fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

fun main() {
    ExampleExt().methodOutside();
}


