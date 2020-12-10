package com.udacity.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import timber.log.Timber


class ShoeListing : Fragment() {
    private lateinit var binding:FragmentShoeListingBinding


private val sharedViewModel:SharedViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShoeListingBinding.inflate(inflater)

        Timber.i(" listing onCreateView called")
        //bind layout to the ViewModel
        binding.sharedViewModel = sharedViewModel

        //make binding observe LiveData
        binding.lifecycleOwner = this

        //observe Navigation event

        sharedViewModel.eventNavigateToShoeDetail.observe(viewLifecycleOwner  ){

            eventNavigate  ->

            if (eventNavigate){

Timber.i("at listing observatory Nav to Detail is $eventNavigate")
                findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetailFragment())
                sharedViewModel.onNavigateToDetailFragmentComplete()
            }
        }


        return binding.root
    }


    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach has been summoned")
    }


}