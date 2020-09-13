package com.example.kotlinsample.demo

class MyClass {
    companion object Factory{
        //value is public
        val value: Int = 10

        //create1 method is public
        fun create1(): Int {
            return value *2
        }

        fun create2() = value * value

        fun create(): MyClass =
            MyClass()
    }
}

class MyClass1 {
    companion object {
        //value is public
        val value: Int = 10

        //create1 method is public
        fun create1(): Int {
            return value *2
        }

        fun create2() = value * value

        fun create(): MyClass =
            MyClass()
    }
}

class MyClass2 {
    companion object {
        //value is public
        val value: Int = 10

        //create1 method is public
        @JvmStatic
        fun create1(): Int {
            return value *2
        }

        fun create2() = value * value

        fun create(): MyClass =
            MyClass()
    }
}

class Class4 {
    companion object {
        @JvmStatic fun callStatic() {}
        fun callNonStatic() {}
    }
}
//
//fun main() {
//    println("ritesh create2 ${MyClass.value}")
//    println("ritesh create1 ${MyClass.create1()}")
//    println("ritesh create2 ${MyClass.create2()}")
//}