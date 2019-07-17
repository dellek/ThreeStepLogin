package com.example.threesteplogin

import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment

/**
 * @author Izame
 *
 * This library implements a 3 steps login flux with a navigation in 3 different fragment
 * You can simply extends in your main activity this library ThreeStepFlux() and you have done.The library do the rest!
 *
 * The first fragment is a simple form
 * In the second one, user can choose an username and password
 * Last fragment is a recap who show if everything is ok
 *
 *
 * Soon I add customization to layout for more usability
 *
 * ------ enjoy ------
 */

open class ThreeStepFlux : AppCompatActivity(){

    private lateinit var nav:NavHostFragment
    private lateinit var graph:NavGraph
    private lateinit var threeStepLayout:ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_step_flux)
    }

    override fun onBackPressed() {}

    fun initFlux(){
        nav = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        graph = nav.navController.navInflater.inflate(R.navigation.nav_graph)
        threeStepLayout = findViewById(R.id.three_step_layout)
        graph.startDestination = R.id.step1Fragment
    }

    fun changeLayoutAppearence(){
        AlertDialog.Builder(this)
            .setTitle("Choose layout appearence")
            .setMessage("You can choose once and changes cannot be undone.Cancel load default layout")
            .setPositiveButton(R.string.proceed) { _, _ ->
                changeBackground()
            }
            .setNegativeButton(R.string.cancel,null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun changeBackground(){
        AlertDialog.Builder(this)
            .setTitle("Background")
            .setMessage("Choose a color for background")
            .setSingleChoiceItems(arrayOf("red","green","blue"),-1){ _,item->
                when(item){
                    0 -> threeStepLayout.setBackgroundColor(Color.RED)
                    1 -> threeStepLayout.setBackgroundColor(Color.GREEN)
                    2 -> threeStepLayout.setBackgroundColor(Color.BLUE)
                }
            }
            .setPositiveButton(android.R.string.yes,null)
            .setNegativeButton(android.R.string.no){_,_->
                threeStepLayout.setBackgroundColor(Color.WHITE)
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }
}