package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    private val _eventNavigateToWelcomeScreen = MutableLiveData<Boolean>()
    val eventNavigateToWelcomeScreen: LiveData<Boolean> = _eventNavigateToWelcomeScreen


    //remove backing fields

/* private val _eventNavigateToWelcomeScreen = MutableLiveData<Boolean>()
    val eventNavigateToWelcomeScreen:LiveData<Boolean>
    get() = _eventNavigateToWelcomeScreen*/

    init {

        _eventNavigateToWelcomeScreen.value = false

    }



    fun onNavigateToWelcomeScreen(){

        _eventNavigateToWelcomeScreen.value = true
    }


}