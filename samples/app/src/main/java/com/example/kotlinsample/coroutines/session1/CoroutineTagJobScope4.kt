package com.example.kotlinsample.coroutines.session1

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsample.R
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

// thread switching ; Main, IO, Default, Unconfined
class CoroutineTagJobScope4 : AppCompatActivity() {

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

        val rootScope = CoroutineScope(IO).launch {
            println("ritesh 1 : time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)

            val job1 = launch {
                println("ritesh :  job 1 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 1 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            job1.invokeOnCompletion {
                println("ritesh : job1 invokeOnCompletion : " + it?.localizedMessage)
            }

            val job2 = CoroutineScope(IO + job1).launch {
                println("ritesh :  job 2 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 2 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            val job3 = CoroutineScope(IO + job1).launch {
                println("ritesh :  job 3 before delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
                delay(5000)
                println("ritesh :  job 3 after delay time : " + java.time.LocalTime.now() + " : " + Thread.currentThread().name)
            }

            job3.invokeOnCompletion {
                println("ritesh : job3 invokeOnCompletion : " + it?.localizedMessage)
            }

            job2.invokeOnCompletion {
                println("ritesh : job2 invokeOnCompletion : " + it?.localizedMessage)
            }

            // job1 and job2 both are attached to job1.
            job1.cancel(CancellationException("ritesh cancel job1 request "))
//            job2.cancel(CancellationException("ritesh cancel job2 request "))
        }

        rootScope.invokeOnCompletion {
            println("ritesh : rootScope invokeOnCompletion : " + it?.localizedMessage)
        }
//        rootScope.cancel(CancellationException("ritesh rootScope cancel request "))
    }
}