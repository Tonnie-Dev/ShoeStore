package com.udacity.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {

    //SHOE_LIST
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    //EVENT_NAVIGATE_TO_DETAIL_FRAGMENT
    private val _eventNavigateToShoeDetail = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetail: LiveData<Boolean> =_eventNavigateToShoeDetail
      //  get() = _eventNavigateToShoeDetail


    //EVENT_NAVIGATE_BACK_TO_SHOE_LISTING
    private val _eventNavigateBackToListing = MutableLiveData<Boolean>()
    val eventNavigateBackToListing: LiveData<Boolean>
        get() = _eventNavigateBackToListing


    //OTHER VARIABLES - name, size, company & description
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
    val description: LiveData<String>
        get() = _description

    var edDescription = ""

    //INIT_BLOCK
    init {

        _shoeList.value = mutableListOf()
        _eventNavigateToShoeDetail.value = false
        _eventNavigateBackToListing.value = false

        _name.value = ""

    }


    //SHOE_LISTING_FRAGMENT_METHODS

    fun onEditFabButtonClick() {
        _eventNavigateToShoeDetail.value = true
    }

    fun onNavigateToDetailFragmentComplete() {
        _eventNavigateToShoeDetail.value = false
        _eventNavigateBackToListing.value = false

        _name.value = ""
        _size.value = 0.0
        _company.value = ""
        _description.value = ""

    }


    //SHOE_DETAIL_FRAGMENT_METHODS
    fun onSaveButtonClick() {

        //check value entered for size and set it to 0 if blank
        if (edSize == "") {

            edSize = "0"
        }

        _eventNavigateBackToListing.value = true

        //update MutableLiveData with values from the EditText
        _name.value = edShoeName
        _size.value = edSize.toDouble()
        _company.value = edCompany
        _description.value = edDescription

        //save shoeObject to the _shoeList MutableLiveData
        _shoeList.value?.add(Shoe(edShoeName, edSize.toDouble(), edCompany, edDescription))

    }

    fun onCancelButtonClick() {
        _eventNavigateBackToListing.value = true
    }


    override fun onCleared() {
        super.onCleared()

    }
}