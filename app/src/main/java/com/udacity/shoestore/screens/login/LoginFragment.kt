package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)
        //create instance of ViewModel

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //bind layout to the ViewModel
        binding.viewModel = viewModel

        //make binding observe LiveData
        binding.lifecycleOwner = this

        viewModel.eventNavigateToWelcomeScreen.observe( viewLifecycleOwner) { eventNavigate ->

            if (eventNavigate  ){

                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        //Add title to toolbar

        (activity as AppCompatActivity).supportActionBar?.title = "Sign In"

        return binding.root
    }


}