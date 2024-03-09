package com.example.earthquakesdemo.http

import com.example.earthquakesdemo.base.network.ApiResponse
import com.example.earthquakesdemo.data.EarthquakeBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

val HttpRequestCoroutine: HttpRequestManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    HttpRequestManager()
}

class HttpRequestManager {
    suspend fun getData(): ApiResponse<ArrayList<EarthquakeBean>> {
        return withContext(Dispatchers.IO) {
            val list = async { apiService.getData() }
            list.await()
        }
    }
}