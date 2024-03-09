package com.example.earthquakesdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amap.api.maps2d.CameraUpdateFactory
import com.amap.api.maps2d.MapView
import com.amap.api.maps2d.model.CameraPosition
import com.amap.api.maps2d.model.LatLng
import com.amap.api.maps2d.model.Marker
import com.amap.api.maps2d.model.MarkerOptions
import com.example.earthquakesdemo.R


class MapActivity:AppCompatActivity() {
    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        mapView = findViewById(R.id.map)
        mapView.onCreate(savedInstanceState)
        val latLng = LatLng(intent.getDoubleExtra("lat", 0.0), intent.getDoubleExtra("lng", 0.0))
        val marker: Marker =
            mapView.map.addMarker(MarkerOptions().position(latLng).title("北京").snippet("DefaultMarker"))
//参数依次是：视角调整区域的中心点坐标、希望调整到的缩放级别、俯仰角0°~45°（垂直与地图时为0）、偏航角 0~360° (正北方为0)
        //参数依次是：视角调整区域的中心点坐标、希望调整到的缩放级别、俯仰角0°~45°（垂直与地图时为0）、偏航角 0~360° (正北方为0)
        val mCameraUpdate = CameraUpdateFactory.newCameraPosition(
            CameraPosition(
                latLng,
                18f,
                30f,
                0f
            )
        )
        mapView.map.moveCamera(mCameraUpdate)

    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }


}