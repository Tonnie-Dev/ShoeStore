package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import kotlinx.android.synthetic.main.activity_main.*


class InstructionsFragment : Fragment() {

private lateinit var binding:FragmentInstructionsBinding
private lateinit var viewModel: InstructionsViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //initialize binding
        binding = FragmentInstructionsBinding.inflate(inflater)


        //initialize viewModel
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)

        (activity as AppCompatActivity).supportActionBar?.title = "Instructions"



        //bind layout to the viewModel
        binding.viewModel = viewModel

        //make binding observe LiveData

        binding.lifecycleOwner = this




        //observe Navigation event
        viewModel.eventNavigateToShoeListingFragment.observe(viewLifecycleOwner){ eventNavigate ->

            if (eventNavigate) {

               findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListing())

        }
        }


        return binding.root
    }

   
}