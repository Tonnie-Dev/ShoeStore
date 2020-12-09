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


class ShoeListing : Fragment() {
    private lateinit var binding:FragmentShoeListingBinding


private val sharedViewModel:SharedViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShoeListingBinding.inflate(inflater)


        //bind layout to the ViewModel
        binding.sharedViewModel = sharedViewModel

        //make binding observe LiveData
        binding.lifecycleOwner = this


        //observe Navigation event

        sharedViewModel.eventNavigateToShoeDetail.observe(viewLifecycleOwner  ){

            eventNavigate  ->

            if (eventNavigate){


                findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetailFragment())
            }
        }

        return binding.root
    }


}