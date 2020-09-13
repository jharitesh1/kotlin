package com.example.kotlinsample

import android.util.Log
import java.util.*
import java.util.Collections.emptyList

public class Sample {
    public fun makeItDouble1(value1: Int, isSuccess: Boolean = true, value2: Int): Int{
        Log.i("ritesh", "isSuccess : " + isSuccess);
        return value1 * value2;
    }

    infix fun makeItDouble2( value: Int): Int = value * 2

    public fun makeItDouble3( value: Int) = value * 2

    public fun makeItDouble4( value: Int) {
        Log.i("ritesh", "multipleArgs")
    }
// -----------------------------2--------------------------

    fun <T> singletonList(item: T): List<T> {
        // ...

        return listOf(item)
    }

    fun <T> T.basicToString(): String {  // extension function
        // ...

        return ""
    }

//------------------1----------------------------------------
//        var multipleValues1: List<Int> = multipleArgs(value)
//
//        Log.i("ritesh", "list1 : " + multipleValues1)
//
//        var multipleValues2: List<Int> = multipleArgs(value)
//
//        Log.i("ritesh", "list2 : " + multipleArgs(value, value))
//
//        Log.i("ritesh", "list3 : " + multipleArgs(value, value, value))
//    }
}