package com.example.kotlinsample.demo

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    lateinit var state1: String
    var zip: String = "123456"

    public var stringRepresentation: String
        get() = street
        set(value) {
            setDataFromString(value) // parses the string and assigns values to other properties
        }

    private fun setDataFromString(value: String) {
        print("ritesh stringRepresentation : " + value)
    }
}

fun main() {
//    println(Address().stringRepresentation)
    val address: Address =
        Address()
    println(Address().state1)
}