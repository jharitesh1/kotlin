package com.example.kotlinsample.coroutines.session1

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

// thread switching ; Main, IO, Default, Unconfined
class CoroutineAsyncAwait5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(IO).launch {
            main()
        }
    }

    suspend fun main() {
        //println("ritesh main : " + Thread.currentThread().name)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            method1()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun method1() {

        val rootScope = CoroutineScope(IO).launch {
            println("ritesh 1 : time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)

            val job1 = async {
                println("ritesh :  job 1 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 1 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            val job2 = async {
                println("ritesh :  job 2 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 2 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            job1.invokeOnCompletion {
                println("ritesh : job1 invokeOnCompletion : " + it?.localizedMessage)
            }

            job2.invokeOnCompletion {
                println("ritesh : job2 invokeOnCompletion : " + it?.localizedMessage)
            }

//            println("ritesh : ${job1.await()}")
            println("ritesh : ----- - ${job2.await()}")
        }

        rootScope.invokeOnCompletion {
            println("ritesh : rootScope invokeOnCompletion : " + it?.localizedMessage)
        }
//        rootScope.cancel(CancellationException("ritesh rootScope cancel request "))
    }
}