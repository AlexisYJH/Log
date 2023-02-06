package com.example.log

import android.util.Log

/**
 * @author AlexisYin
 */
fun Any.print(tag: String, msg: String){
    println("$tag, $msg")
}
fun Any.p(msg: String)  = print(this.javaClass.simpleName, msg)
fun Any.print(msg: String)  = print(this.javaClass.name, msg)

fun Any.d(msg: String)  = Log.d(this.javaClass.simpleName, msg)