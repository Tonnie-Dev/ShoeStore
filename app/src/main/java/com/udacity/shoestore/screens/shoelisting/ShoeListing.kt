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
   private val viewModel:ShoeListingViewModel by activityViewModels()

private val viewModel2:SharedViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShoeListingBinding.inflate(inflater)

        //initialize ViewModel
        //viewModel =  ViewModelProvider(this).get(ShoeListingViewModel::class.java)
        //bind layout to the ViewModel
        binding.viewModel = viewModel

        //make binding observe LiveData

        binding.lifecycleOwner = this


        //observe Navigation event

        viewModel.eventNavigateToShoeDetail.observe(viewLifecycleOwner  ){

            eventNavigate  ->

            if (eventNavigate){


                findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetailFragment())
            }
        }

        return binding.root
    }


}