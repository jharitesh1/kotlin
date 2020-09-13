package com.example.kotlinsample.demo

interface MyInterface {
    val prop: Int
    fun bar(): String
    fun foo() = "Parent Foo"
}

class Child() : MyInterface {
    override val prop: Int = 10
    override fun bar() = "Child bar"
    override fun foo() = "Child Foo"
}

fun main() {
    println("ritesh " + Child().bar())
    println("ritesh " + Child().foo())


}
