package com.udacity.shoestore.screens.shoelisting

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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


        //bind layout to the ViewModel
        binding.sharedViewModel = sharedViewModel

        //make binding observe LiveData
        binding.lifecycleOwner = this

        //observe Navigation event
        sharedViewModel.eventNavigateToShoeDetail.observe(viewLifecycleOwner) {

            eventNavigate ->

            if (eventNavigate) {
                findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetailFragment())
                sharedViewModel.onNavigateToDetailFragmentComplete()
            }
        }

        //observe shoeList for changes and inflate layout
        sharedViewModel.shoeList.observe(viewLifecycleOwner) {

            newShoeList ->

            if (newShoeList.isNotEmpty()) {

                //inflate  each shoe on the list
                newShoeList.forEach { shoe -> inflateShoeLabels(shoe) }
            }
        }


        //Add title to toolbar
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Listing"

        //set has options menu to true

        setHasOptionsMenu(true)



        return binding.root
    }

    //create layout item with respective textView value insert border
    private fun inflateShoeLabels(shoe: Shoe) {


        val sizeString =doubleToString(shoe.size)
        createTextLabel(getString(R.string.styled_shoe_name), shoe.name)
        createTextLabel(getString(R.string.styled_size), sizeString)
        createTextLabel(getString(R.string.styled_company_name), shoe.company)
        createTextLabel(getString(R.string.styled_description), shoe.description)

        //insert border between items
        insertBorder()
    }

    //draw one textView
    private fun createTextLabel(boldLabel: String, subtext:String) {


        val textView = TextView(context)
        //params to position the text view
        val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 30)
        params.gravity = Gravity.CENTER
        textView.layoutParams = params

        textView.text = formatText(boldLabel, subtext)
        linearLayout.addView(textView)

    }

    //insert border between shoe objects
    private fun insertBorder() {
        val textView = TextView(context)

        //params to position border text view
        val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 30)
        params.gravity = Gravity.CENTER
        textView.layoutParams = params

        //border height
        textView.height = 2


        //background color
        textView.setBackgroundColor(resources.getColor(R.color.colorAccent))
        linearLayout.addView(textView)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())||super
                .onOptionsItemSelected(item)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


      val callback = requireActivity().onBackPressedDispatcher.addCallback(this){
findNavController().navigate(ShoeListingDirections.actionShoeListingToLoginFragment())
      }
}

fun formatText (s1:String, s2:String): Spanned{
    val sb = StringBuilder()

    sb.apply {



        append(s1)

        append(s2)
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }



}


    fun doubleToString(double:Double):String{

return String.format("%.1f", double)

    }
}






