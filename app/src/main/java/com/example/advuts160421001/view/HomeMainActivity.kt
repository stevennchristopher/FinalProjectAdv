package com.example.advuts160421001.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.ActivityHomeMainBinding

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeMainBinding
    private lateinit var navController: NavController

    companion object {
        val activeIdUser = "random_16071239872_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val activeIdUser = intent.getStringExtra(activeIdUser)
        Log.d("testiduser", activeIdUser.toString())

        navController = (supportFragmentManager.findFragmentById(R.id.hostHomeFragment) as NavHostFragment).navController
        binding.bottomNav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
                || super.onSupportNavigateUp()
    }
}