package com.example.threesteplogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment

open class ThreeStepFlux : AppCompatActivity(){

    private lateinit var nav:NavHostFragment
    private lateinit var graph:NavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigator_host)
        nav = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        graph = nav.navController.navInflater.inflate(R.navigation.nav_graph)
        graph.startDestination = R.id.step1Fragment
    }

    override fun onBackPressed() {}
}