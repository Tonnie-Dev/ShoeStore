package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {

    private val _eventNavigateToInstructionsFragment = MutableLiveData<Boolean>()
    val eventNavigateToInstructionsFragment:LiveData<Boolean>
    get() = _eventNavigateToInstructionsFragment

    init {


        _eventNavigateToInstructionsFragment.value = false

    }


    fun onNavigateToInstructionsFragment() {
        _eventNavigateToInstructionsFragment.value = true
    }
}