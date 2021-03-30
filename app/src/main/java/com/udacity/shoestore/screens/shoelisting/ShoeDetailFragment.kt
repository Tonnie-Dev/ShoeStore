package com.udacity.shoestore.screens.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentShoeDetailBinding.inflate(inflater)

        //bind layout to viewModel
        binding.sharedViewModel = sharedViewModel


        //make binding observe LiveData
        binding.lifecycleOwner = this


        //observe Nav Event
        sharedViewModel.eventNavigateBackToListing.observe(
                viewLifecycleOwner) { eventNavigateBack ->

            if (eventNavigateBack) {


                findNavController().navigate(
                        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListing())
            }
        }


        //Add title to toolbar
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.add_shoe)
        return binding.root
    }


}