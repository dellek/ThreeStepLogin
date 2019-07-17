package com.example.threesteplogin

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_step_flux)
        nav = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        graph = nav.navController.navInflater.inflate(R.navigation.nav_graph)
        graph.startDestination = R.id.step1Fragment
        Toast.makeText(this,"Sono la libreria",Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {}
}