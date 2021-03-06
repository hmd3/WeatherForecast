package com.example.weatherforecast.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.logic.Repository
import com.example.weatherforecast.logic.model.Location

// 封装ViewModel对象，防止旋转屏幕等使数据丢失
class WeatherViewModel : ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {//刷新天气信息
        locationLiveData.value = Location(lng, lat)
    }
}