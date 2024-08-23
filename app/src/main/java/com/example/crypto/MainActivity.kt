package com.example.crypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.crypto.Fragments.HomeFragment
import com.example.crypto.Fragments.ProfileFragment
import com.example.crypto.Fragments.SearchFragment
import com.example.crypto.ui.theme.CryptoTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.ic_home -> makeCurrentFragment(homeFragment)
                    R.id.ic_search -> makeCurrentFragment(searchFragment)
                    R.id.ic_profile -> makeCurrentFragment(profileFragment)
                }
            true
        }

        }
    //TODO: Method to call Fragment
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}



