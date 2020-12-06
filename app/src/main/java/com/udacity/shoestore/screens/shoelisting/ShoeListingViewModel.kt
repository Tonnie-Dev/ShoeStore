package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListingViewModel : ViewModel() {

    private val _eventNavigateToShoeDetail = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetail:LiveData<Boolean>
    get() = _eventNavigateToShoeDetail


    init {

        _eventNavigateToShoeDetail.value = false

    }

    fun onNavigateToShoeDetail() {

        _eventNavigateToShoeDetail.value = true
    }
}