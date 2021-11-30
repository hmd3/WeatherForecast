package com.example.weatherforecast.logic.network

import com.example.weatherforecast.WeatherForecastApplication
import com.example.weatherforecast.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// 用于城市搜索的Retrofit接口
interface PlaceService {
    @GET("v2/place?token=${WeatherForecastApplication.TOKEN}&lang=zh_CN")//发送GET请求访问地址
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>//返回PlaceResponse对象
}