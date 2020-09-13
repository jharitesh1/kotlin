package com.example.kotlinsample.demo

open class A(x: Int) {
    public open val y: Int = x
}

interface B { /*...*/
    public open val y: Int
}

val demoObjects: A = object : A(1),
    B {

}

class C {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // Works
//        val x2 = publicFoo().x  // ERROR: Unresolved reference 'x'
    }
}

fun main() {

    val value = object {
        val a: Int = 10
        val b: Int = 20
    }

    println("ritesh : " + demoObjects.y)
    println("ritesh : " + value.a)
}