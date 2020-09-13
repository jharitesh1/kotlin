package com.example.kotlinsample.demo

import com.example.kotlinsample.demo.AbstractGenericSampleCode

class GenericSampleCodeChild2<T>(s: String): AbstractGenericSampleCode<String>(s) {

    override fun methodToExpose(): String {
        return "comes from method of Child2"
    }
}