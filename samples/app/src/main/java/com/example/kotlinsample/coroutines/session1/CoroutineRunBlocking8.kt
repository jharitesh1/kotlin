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

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

class CoroutineRunBlocking8 : AppCompatActivity() {

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
//                        processOnIoUsingCoroutine();
                    processOnIoUsingThread()
//                        processOnMainUsingThread()
                }
            }
        }
    }

    suspend fun processOnIoUsingCoroutine() {
        CoroutineScope(IO).launch {
            println("ritesh before delay ${count}")
            delay(6000)
            println("ritesh after delay ")
        }
    }

    suspend fun processOnIoUsingThread() {
        CoroutineScope(IO).launch {
            println("ritesh before delay ${count}")
            Thread.sleep(6000)
            println("ritesh after delay ")
        }
    }

    suspend fun processOnMainUsingThread() {
        CoroutineScope(Main).launch {
            println("ritesh before delay ${count}")
            Thread.sleep(6000)
            println("ritesh after delay ")
        }
    }
}