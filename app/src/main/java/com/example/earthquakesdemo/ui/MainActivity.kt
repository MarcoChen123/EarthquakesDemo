package com.example.earthquakesdemo.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquakesdemo.databinding.ActivityMainBinding
import com.example.earthquakesdemo.vm.MainViewModel
import com.example.earthquakesdemo.widget.EarthquakeAdapter
import com.example.pokemonkotlindemo.base.activity.BaseActivity

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private val earthquakeAdapter: EarthquakeAdapter by lazy { EarthquakeAdapter(arrayListOf()) }

    override fun initView(savedInstanceState: Bundle?) {
        mViewModel.getData()
        mDatabind.recycler.layoutManager = LinearLayoutManager(this)
        mDatabind.recycler.adapter = earthquakeAdapter
    }

    override fun createObserver() {
        super.createObserver()
        mViewModel.earthquakeList.observe(this, {
            earthquakeAdapter.update(it)
        })
    }
}