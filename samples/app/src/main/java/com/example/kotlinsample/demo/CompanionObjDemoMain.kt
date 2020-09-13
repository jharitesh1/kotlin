package com.example.kotlinsample.demo

fun main() {
    //value is public in MyClass.
    println("ritesh create2 ${MyClass.value}")
    println("ritesh create1 ${MyClass.create1()}")
    println("ritesh create2 ${MyClass.create2()}")
    println("ritesh create ${MyClass.create()}")
    println("ritesh create ${MyClass.create()}")
    println("ritesh create ${MyClass.create()}")
    println("ritesh create ${MyClass.create()}")
    println("ritesh create ${MyClass.create()}")

    println("ritesh create2 ${MyClass.Factory.value}")
    println("ritesh create1 ${MyClass.Factory.create1()}")
    println("ritesh create2 ${MyClass.Factory.create2()}")

    //value is public in MyClass.
    println("ritesh create2 ${MyClass1.value}")
    println("ritesh create1 ${MyClass1.create1()}")
    println("ritesh create2 ${MyClass1.create2()}")

    println("ritesh create2 ${MyClass1.Companion.value}")
    println("ritesh create2 ${MyClass1.Companion.create1()}")
    println("ritesh create2 ${MyClass1.Companion.create2()}")


    println("ritesh create3 ${MyClass2.Companion.create1()}")

    println("ritesh create4 : " + Class4.callStatic())
    println("ritesh create4 : " + Class4.callNonStatic())

}