package com.example.earthquakesdemo.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.earthquakesdemo.base.utils.request
import com.example.earthquakesdemo.base.vm.BaseViewModel
import com.example.earthquakesdemo.data.EarthquakeBean
import com.example.earthquakesdemo.http.HttpRequestCoroutine

class MainViewModel : BaseViewModel() {
    var earthquakeList: MutableLiveData<ArrayList<EarthquakeBean>> = MutableLiveData()

    fun getData() {
        request({ HttpRequestCoroutine.getData()}, {
            Log.i("cwx", "http success -------- $it")
            earthquakeList.postValue(it)
        }, {
            Log.i("cwx", "http error -------- ${it.errorMsg}")
        })
    }
}