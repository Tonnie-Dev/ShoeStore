package com.udacity.shoestore.screens.shoelisting

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_listing.*
import timber.log.Timber


class ShoeListing : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding


    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentShoeListingBinding.inflate(inflater)

        Timber.i(" listing onCreateView called")
        //bind layout to the ViewModel
        binding.sharedViewModel = sharedViewModel

        //make binding observe LiveData
        binding.lifecycleOwner = this

        //observe Navigation event

        sharedViewModel.eventNavigateToShoeDetail.observe(viewLifecycleOwner) {

            eventNavigate ->

            if (eventNavigate) {

                Timber.i("at listing observatory Nav to Detail is $eventNavigate")
                findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetailFragment())
                sharedViewModel.onNavigateToDetailFragmentComplete()
            }
        }

        sharedViewModel.shoeList.observe(viewLifecycleOwner) {

            newShoeList ->

            if (newShoeList.isNotEmpty()) {


                newShoeList.forEachIndexed { _, shoe -> createShoeLabel(shoe) }
            }
        }


        return binding.root
    }


    private fun createShoeLabel(shoe: Shoe) {

        //val shoe = shoeList.last()
        createTextLabel(shoe.name)
        createTextLabel(shoe.size.toString())
        createTextLabel(shoe.company)
        createTextLabel(shoe.description)
        insertBoarder()
    }

    private fun createTextLabel(label: String) {


        val textView = TextView(context)
        val params =
                LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 30)
        params.gravity = Gravity.CENTER
        textView.layoutParams = params
        textView.text = label
        linearLayout.addView(textView)

    }


private fun insertBoarder(){
    val textView = TextView(context)
    val params =
            LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    params.setMargins(0, 0, 0, 30)
    params.gravity = Gravity.CENTER
    textView.layoutParams = params
    textView.height = 5
    textView.setBackgroundColor(Color.GREEN)
    linearLayout.addView(textView)


}

}






