package com.example.threesteplogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class NavigatorHost : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigator_host)
        var nav = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        var graph = nav.navController.navInflater.inflate(R.navigation.nav_graph)
    }

    override fun onBackPressed() {}
}