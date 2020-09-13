package com.example.kotlinsample.coroutines.session1

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

// thread switching ; Main, IO, Default, Unconfined
class CoroutineJobs3 : AppCompatActivity() {

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
        delay(2000)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            method1()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun method1() {

        withContext(IO) {

            println("ritesh 1 : time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)

            val job1 = launch {
                println("ritesh :  job 1 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 1 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            job1.invokeOnCompletion {
                println("ritesh :  job 1 invokeOnCompletion  " + it?.localizedMessage)
            }

            println("ritesh 2: time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)

            val job2 = withTimeoutOrNull(4000) {
                println("ritesh : job 2 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh : job 2 after delay time " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            if (job2 == null) {
                job1.cancel(CancellationException("ritesh :  job 1 resetting job1 "))

                println("riteshob 2 after finish : time returning null" + java.time.LocalTime.now() + " : " + Thread.currentThread().name)

                withContext(Main) {
                    textView.text = ("ritesh method1 --3 -- returning null" + " : "
                            + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                    println(
                        "ritesh method1 --3 -- returning null" + " : "
                                + java.time.LocalTime.now() + " : " + Thread.currentThread().name
                    )
                }
            }

            println("ritesh 3: time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
        }
    }
}