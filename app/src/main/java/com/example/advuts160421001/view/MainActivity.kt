package com.example.advuts160421001.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.ActivityMainBinding
import com.example.advuts160421001.model.HobbyDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var databinding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = ActivityMainBinding.inflate(layoutInflater)
        val view = databinding.root
        setContentView(view)

//        HobbyDatabase.invoke(this)

        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}