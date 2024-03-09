package com.example.earthquakesdemo.base.vm

import androidx.lifecycle.ViewModel
import com.kunminx.architecture.ui.callback.UnPeekLiveData

open class BaseViewModel : ViewModel() {

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 跟网络请求显示隐藏loading配套
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { UnPeekLiveData<String>() }
        //隐藏
        val dismissDialog by lazy { UnPeekLiveData<Boolean>() }
    }

}