package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        //set toolbar using android ext lib
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //find nav controller
        val navController = findNavController(R.id.nav_host_fragment)

       //appConfig
       val appBarConfig = AppBarConfiguration(setOf(R.id.loginFragment, R.id.welcomeFragment, R.id
               .instructionsFragment, R.id.shoeListing))
        // setup the nav controller with the toolbar and an AppBarConfiguration
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfig)
    }




    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
