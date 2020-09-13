package com.example.kotlinsample.coroutines.session1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.activity_main_button.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

//runBlocking will delay the current thread until completion. Once the current job is done
//then only it will start the next job scheduled on existing thread.

class CoroutineFreezeUi7 : AppCompatActivity() {

    private var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_button)
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(Main).launch {

            buttonClick?.setOnClickListener {
                buttonClick.text = (count++).toString()
                CoroutineScope(IO).launch {
                    processOnIoUsingCoroutine()
                }
            }
        }
    }

    suspend fun processOnIoUsingCoroutine() {
//        CoroutineScope(IO).launch {
        CoroutineScope(Main).launch {
            println("ritesh job1 ")
            delay(1000)
            println("ritesh job1 delay1 ")

            delay(1000)
            println("ritesh  job1 delay2 ")

            delay(1000)
            println("ritesh job1 delay3 ")

            delay(1000)
            println("ritesh job1 delay4 ")

            delay(1000)
            println("ritesh job1 delay5 ")
        }

//        CoroutineScope(IO).launch {
        CoroutineScope(Main).launch {
            println("ritesh job2 ")
            runBlocking {
                delay(1000)
                println("ritesh job2 delay1 ")

                delay(1000)
                println("ritesh  job2 delay2 ")

                delay(1000)
                println("ritesh job2 delay3 ")

                delay(1000)
                println("ritesh job2 delay4 ")

                delay(1000)
                println("ritesh job2 delay5 ")
            }
        }
    }
}