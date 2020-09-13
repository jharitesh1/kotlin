package com.example.kotlinsample.demo

import android.util.Log
import com.example.kotlinsample.demo.AbstractGenericSampleCode

class GenericSampleCodeChild1<T>(i: Int) : AbstractGenericSampleCode<Int>(i) {
    val argument: Int = i

    override fun methodToExpose(): Int {
        return argument * 100;
    }

    override fun methodFree() {
        Log.i("ritesh", "Freemethod -- printing from chile1 ");
        super.methodFree()
    }
}