package com.example.kotlinsample.demo

open class Base1 { }

class Derived1 : Base1() { }

open class BaseCaller1 {
    open fun Base1.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived1.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }
}

fun <T> MutableList<T>.swap(value1: T, value2: T) {
    println("ritesh "+ value1 + " : " + value2)
}

fun main() {
    val list = mutableListOf(3,4)
    list.swap(2, 3)

    val list1 = mutableListOf("ritesh","jha")
    list1.swap(list1.get(0), list1.get(1))

//    CustomBottomSheetHelper.BottomSheetCallback mCallback = Custo
}

public class CustomBottomSheetHelper {

    interface BottomSheetCallback {
        fun onBottomSheetLoaded(items: List<String>)
    }
}





