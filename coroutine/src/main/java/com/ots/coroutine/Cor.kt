package com.ots.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val launch = GlobalScope.launch {
        delay(1000L) // 无阻塞的等待1秒钟（默认时间单位是毫秒）
        println("World!") // 在
    }

    runBlocking()

}