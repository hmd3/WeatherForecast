package com.example.weatherforecast.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.logic.Repository
import com.example.weatherforecast.logic.model.Place

// ViewModel层，防止旋转屏幕等一系列操作导致数据丢失
class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()//数据缓存

    val placeLiveData = Transformations.switchMap(searchLiveData) {query ->//观察对象
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    //Dao层封装
    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}