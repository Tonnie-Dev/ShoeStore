package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    private val _eventNavigateToWelcomeScreen = MutableLiveData<Boolean>()
    val eventNavigateToWelcomeScreen:LiveData<Boolean>
    get() = _eventNavigateToWelcomeScreen



    init {

        _eventNavigateToWelcomeScreen.value = false

    }



    fun navigateToWelcomeScreen(){

        _eventNavigateToWelcomeScreen.value = true
    }


}