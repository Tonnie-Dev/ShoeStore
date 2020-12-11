package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {

    //EVENT_NAVIGATE_TO_DETAIL_FRAGMENT
    private val _eventNavigateToShoeDetail = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetail: LiveData<Boolean>
        get() = _eventNavigateToShoeDetail

    //EVENT_NAVIGATE_TO_DETAIL_FRAGMENT_COMPLETE
    private val _eventNavigateToShoeDetailCompleted = MutableLiveData<Boolean>()
    val eventNavigateToShoeCompleted: LiveData<Boolean>
        get() = _eventNavigateToShoeDetailCompleted


    //EVENT_NAVIGATE_BACK_TO_SHOE_LISTING
    private val _eventNavigateBackToListing = MutableLiveData<Boolean>()
    val eventNavigateBackToListing: LiveData<Boolean>
        get() = _eventNavigateBackToListing

    //SHOE_LIST
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    var edShoeName = ""

    private val _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size
    var edSize = ""

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company
    var edCompany = ""

    private val _description = MutableLiveData<String>()
    val description:LiveData<String>
    get() = _description

    var edDescription = ""


    init {

        _shoeList.value = mutableListOf()
        _eventNavigateToShoeDetail.value = false
        _eventNavigateBackToListing.value = false
        _eventNavigateToShoeDetailCompleted.value = false
        _name.value = ""

    }


    //SHOE_LISTING_FRAGMENT_METHODS

    fun onEditFabButtonClick() {
        _eventNavigateToShoeDetail.value = true


    }

    fun onNavigateToDetailFragmentComplete() {
        _eventNavigateToShoeDetail.value = false
        _eventNavigateBackToListing.value = false
        Timber.i("Nav Value to DetailFragment ${_eventNavigateToShoeDetail.value}")
    }


    //SHOE_DETAIL_FRAGMENT_METHODS
    fun onSaveButtonClick() {

        _eventNavigateBackToListing.value = true

        //update MutableLiveData with values on the EditText
        _name.value = edShoeName
        _size.value = edSize.toDouble()
        _company.value = edCompany
        _description.value = edDescription

        //add a new shoeList Element


    }

    fun onCancelButtonClick() {
        _eventNavigateBackToListing.value = true
    }


    override fun onCleared() {
        super.onCleared()

        Timber.i("onCleared has been summoned")
    }
}