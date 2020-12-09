package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel: ViewModel() {

    //EVENT_NAVIGATE_TO_DETAIL_FRAGMENT
    private val _eventNavigateToShoeDetail = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetail:LiveData<Boolean>
    get() = _eventNavigateToShoeDetail

//SHOE_LIST
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList:LiveData<MutableList<Shoe>>
    get()= _shoeList

    init {

        _shoeList.value = mutableListOf()
        _eventNavigateToShoeDetail.value = false

    }


    fun onNavigateToShoeDetail() {
        _eventNavigateToShoeDetail.value = true
    }
}