package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel:ViewModel() {

    private val _eventNavigateToShoeListingFragment= MutableLiveData<Boolean>()
    val eventNavigateToShoeListingFragment:LiveData<Boolean>
    get() = _eventNavigateToShoeListingFragment


    init {

        _eventNavigateToShoeListingFragment.value = false

    }


    fun onNavigateToShoeListingFragment() {

        _eventNavigateToShoeListingFragment.value = true
    }
}