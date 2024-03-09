package com.example.earthquakesdemo.base.network


data class ApiResponse<T>(val errorCode: Int, val errorMsg: String,val type: String, val features: T) : BaseResponse<T>() {

    override fun isSucces() = errorCode == 0

    override fun getResponseCode() = errorCode

    override fun getResponseData() = features

    override fun getResponseMsg() = errorMsg

}