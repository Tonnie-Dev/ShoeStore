package com.udacity.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import kotlinx.android.synthetic.main.fragment_shoe_listing.*
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

        sharedViewModel.shoeList.observe(viewLifecycleOwner){

            newShoeList ->

            if (newShoeList.isNotEmpty()){


                val button1 = Button(context)
                button1.text = "Press Me1"
                linearLayout.addView(button1)
                val button2 = Button(context)
                button2.text = "Press Me2"
                linearLayout.addView(button2)

                val button3 = Button(context)
                button3.text = "Press Me3"
                linearLayout.addView(button3)


            }
        }


        return binding.root
    }




}