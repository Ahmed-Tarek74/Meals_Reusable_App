package com.example.meal_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment :NavHostFragment
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.navController
    }
}