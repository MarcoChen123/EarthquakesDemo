package com.example.earthquakesdemo.base.ui

import android.view.View
import androidx.databinding.ViewDataBinding
import com.example.earthquakesdemo.base.utils.inflateBindingWithGeneric
import com.example.earthquakesdemo.base.vm.BaseViewModel

abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    override fun layoutId() = 0

    lateinit var mDatabind: DB

    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mDatabind = inflateBindingWithGeneric(layoutInflater)
        return mDatabind.root
    }
}