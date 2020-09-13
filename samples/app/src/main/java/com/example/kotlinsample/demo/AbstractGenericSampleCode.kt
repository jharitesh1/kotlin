package com.example.kotlinsample.demo

import android.util.Log

abstract class AbstractGenericSampleCode <T> (t: T) {
    private val value = t

    abstract fun methodToExpose(): T

     open fun methodFree() {
         Log.i("ritesh", "Free Method from abstract class")
     }

    fun method() {
        Log.i("ritesh", "AbstractGenericSampleCode  : " + methodToExpose() + " : " + value.toString());
    }
}