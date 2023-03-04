package com.example.testandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.testandroid.R
import com.example.testandroid.databinding.ActivityMainBinding
import com.example.testandroid.ui.popular.PopularFragment
import com.example.testandroid.ui.top.TopFragment
import com.example.testandroid.ui.upcoming.UpcomingFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val popularFragment = PopularFragment()
    private val upcomingFragment = UpcomingFragment()
    private val topFragment = TopFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(popularFragment)

        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.popular -> replaceFragment(popularFragment)
                R.id.child -> replaceFragment(upcomingFragment)
                R.id.movies -> replaceFragment(topFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}