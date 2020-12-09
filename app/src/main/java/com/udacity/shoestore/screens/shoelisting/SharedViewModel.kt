package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    //EVENT_NAVIGATE_TO_DETAIL_FRAGMENT
    private val _eventNavigateToShoeDetail = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetail: LiveData<Boolean>
        get() = _eventNavigateToShoeDetail

    //EVENT_NAVIGATE_BACK_TO_SHOE_LISTING
    private val _eventNavigateBack = MutableLiveData<Boolean>()
    val eventNavigateBack:LiveData<Boolean>
    get() = _eventNavigateBack

    //SHOE_LIST
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {

        _shoeList.value = mutableListOf()
        _eventNavigateToShoeDetail.value = false
        _eventNavigateBack . value = false

    }


    fun onEditFabButtonClick() {
        _eventNavigateToShoeDetail.value = true
    }

    fun onSaveButtonClick() {

        _eventNavigateBack.value = true

    }

    fun onCancelButtonClick() {
        _eventNavigateBack.value = true
    }
}