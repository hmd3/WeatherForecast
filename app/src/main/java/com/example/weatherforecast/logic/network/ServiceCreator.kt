package com.example.weatherforecast.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit构建器，是一个单例类
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"//根路径

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java) // 内联函数，类型擦除，泛型实化
}