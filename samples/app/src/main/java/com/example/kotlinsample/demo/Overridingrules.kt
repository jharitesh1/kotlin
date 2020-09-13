package com.example.kotlinsample.demo

open class Rectangle {
    open fun draw() { println("ritesh Rectangle") }
}

interface Polygon {
    fun draw() { println("ritesh Polygon") }
}

class Square : Rectangle(),
    Polygon {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}

fun main() {
    Square().draw()
}