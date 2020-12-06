package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
private lateinit var binding:FragmentWelcomeBinding
private lateinit var viewModel:WelcomeViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {


        binding = FragmentWelcomeBinding.inflate(inflater)


        //initialize viewModel
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        //bind layout to viewModel
        binding.viewModel = viewModel

        //make binding observe LiveData

        binding.lifecycleOwner = viewLifecycleOwner


                //observe navigation event
        viewModel.eventNavigateToInstructionsFragment.observe(viewLifecycleOwner){ eventNavigate ->

            if (eventNavigate){

                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())

            }
        }



        // Inflate the layout for this fragment
        return binding.root
    }


}