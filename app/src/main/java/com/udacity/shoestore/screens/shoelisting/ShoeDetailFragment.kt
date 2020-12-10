package com.udacity.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private val sharedViewModel:SharedViewModel by activityViewModels()
    private lateinit var binding:FragmentShoeDetailBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Timber.i(" detail onCreateView called")
        binding = FragmentShoeDetailBinding.inflate(inflater)

        val vm = ViewModelProvider(this).get(sharedViewModel::class.java)

        //bind layout to viewModel

        binding.sharedViewModel = sharedViewModel


        //make binding observe LiveData
        binding.lifecycleOwner = this


        //observe

        sharedViewModel.eventNavigateBackToListing.observe(viewLifecycleOwner){ eventNavigateBack ->

            if (eventNavigateBack){


                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListing())
            }
        }

        return binding.root
    }


}