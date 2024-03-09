package com.example.earthquakesdemo.api

import com.example.earthquakesdemo.base.network.ApiResponse
import com.example.earthquakesdemo.data.EarthquakeBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/fdsnws/event/1/query?format=geojson&starttime=2023-01-01&endtime=2024-01-01&minmagnitude=7")
    suspend fun getData() : ApiResponse<ArrayList<EarthquakeBean>>
}