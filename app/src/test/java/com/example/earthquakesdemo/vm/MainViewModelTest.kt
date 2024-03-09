package com.example.earthquakesdemo.vm

import com.example.earthquakesdemo.http.HttpRequestCoroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test
import java.util.concurrent.CountDownLatch

internal class MainViewModelTest {

    @Test
    fun getData() {
        val signal = CountDownLatch(1)
        GlobalScope.launch {
            val list = HttpRequestCoroutine.getData()
            System.out.println(list)
            signal.countDown()
        }
        signal.await()
    }
}