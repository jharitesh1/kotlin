package com.example.kotlinsample.demo

import android.util.Log

//open class GenericSampleCode <T> (t: T) {
open class GenericSampleCode <T> (t: T) {
    private val value = t

    fun method() {
        Log.i("ritesh", "GenericSampleCode  : " + value.toString());
    }
}

class Demo: GenericSampleCode<Int>(2) {

}