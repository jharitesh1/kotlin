package com.example.kotlinsample.coroutines.session1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// This class will call suspend function. Ways to call suspend function.
//Scope and context on suspend function.

// thread switching ; Main, IO, Default, Unconfined
class CoroutineScope1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(IO).launch {
            main()
        }
//        CoroutineScope(IO).launch {
//            main()
//        }
//        CoroutineScope(IO).launch {
//            main()
//        }
//        CoroutineScope(IO).launch {
//            main()
//        }

//        GlobalScope.launch {
//            main()
//        }
    }

    suspend fun main() {
        println("ritesh main : " + Thread.currentThread().name)
        delay(2000)
        method1()
    }

    suspend fun method1() {

        // processing done.... now its time for UI update.
        CoroutineScope(Main).launch {
            println("ritesh method1 inside main - " + Thread.currentThread().name)
            textView.text = "Hello"
        }

        withContext(Main) {
            textView.text = "Hello Again"
        }
    }
}