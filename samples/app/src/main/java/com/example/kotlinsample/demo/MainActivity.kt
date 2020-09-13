package com.example.kotlinsample.demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.kotlinsample.R

object Singleton{
    val value: Int = 5;
}

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun <T> singletonList(item: T): List<T> {
        // ...

        return listOf(item)
    }

    override fun onResume() {
//        Singleton.value
        super.onResume()

//        Demo4("ritesh", "jha")
//        Demo2("<<>>>")

//        GenericsAbstractClass()

//        genericClass()
//        genericFunction()

//        Rectangle3(5)
//        Rectangle2()
    }

    interface Shape {
        val count: Int
    }

    class Rectangle1: Shape {
        override val count: Int = 4
    }

    class Rectangle2(override val count: Int = 4):
        Shape {
        init {
            Log.i("ritesh", "Rectangle2 : ${count}")
        }

        open val size: Int =
            count.also { android.util.Log.i("ritesh", "Rectangle2 --: $it") }

    }

    class Rectangle3(override val count: Int):
        Shape {
        init {
            Log.i("ritesh", "Rectangle 3 : ${count}" )
        }
    }


    class Demo8()
    class Demo9 (str: String)
    class Demo7(str1: String, str2: String) {
        val str1: String = str1
        val str2: String = str2
    }

    class Demo5

    class Demo3 constructor(str: String)

    class Demo6 (str: String)

    class Demo4 {

        init {
            Log.i("ritesh", "Demo4 : init" )
        }
        constructor(firstName: String, lastName: String): this(firstName) {
            Log.i("ritesh", "Demo4 : const 2 " )
        }

        constructor(firstName: String) {
            Log.i("ritesh", "Demo4 : const 1 " )
        }
    }

    class Class4 {
        companion object {
            @JvmStatic fun callStatic() {}
            fun callNonStatic() {}
        }
    }

    class Demo2(first: String) {
        init {
            var list: MutableList<Any> = mutableListOf<Any>()
            list.add("ritesh1")
            list.add("2")

            Log.i("ritesh", "init block : " + list.toString() )
        }
    }

    private fun GenericsAbstractClass() {
        val child1: GenericSampleCodeChild1<Int> =
            GenericSampleCodeChild1<Int>(3);
        val child2: GenericSampleCodeChild2<String> =
            GenericSampleCodeChild2<String>("<<from mainActivity constructor >> ");

        //        child1.method()
        //        child1.methodFree()
        //        child2.methodFree()

        //        child2.method()
    }

    private fun genericClass() {
        val obj1: GenericSampleCode<Int> =
            GenericSampleCode<Int>(2)
        obj1.method()

        val obj2: GenericSampleCode<String> =
            GenericSampleCode<String>("ritesh is printing")
        obj2.method()
    }

    private fun genericFunction() {
        val value1 = singletonList<Int>(1)
        Log.i("ritesh", "testing value1 Int : ${value1}");

        val value2 = singletonList<String>("code")
        Log.i("ritesh", "testing value2 String : ${value2}");

        val value3 = singletonList<Double>(3.4)
        Log.i("ritesh", "testing value3 String : ${value3}");
    }

//        val doubleValue1: Int = Sample().makeItDouble1(value1 = 1, value2 = 2)
//        Log.i("ritesh", "doubleValue1 : " + doubleValue1);
//
//        val doubleValue2: Int = Sample().makeItDouble2(2)
//        Log.i("ritesh", "doubleValue2 : " + doubleValue2);
//
//        val doubleValue3: Int = Sample().makeItDouble3(2)
//        Log.i("ritesh", "doubleValue3 : " + doubleValue3);
//
//
//        val doubleValue4: Unit = Sample().makeItDouble4(2)
//        Log.i("ritesh", "doubleValue4 : " + doubleValue4);


//        val callable : Callable<String> = Callable {
//            // Lambda Expression
//            Thread.sleep(600)
//            Thread.currentThread().name
//        }
//
////        callable.call();
//
//        val exe : ExecutorService = Executors.newFixedThreadPool(10)
//
//        for( i in 0..10) {
//            try {
//                val future : Future<String> = exe.submit(callable)
//                future.cancel(true);
//                Log.i("ritesh", "future : $i : " + future.get())
//            }
//            catch (e: CancellationException) {
//                Log.i("ritesh", "cancelled  " + e.message )
//            }
//        }

}