package com.example.esoftwaricaclone

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.esoftwaricaclone.adapter.Communicator
import com.example.esoftwaricaclone.ui.home.HomeFragment

class MainActivity : AppCompatActivity(),Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun passData(
        id: Int,
        name: String,
        age: Int,
        gender: String,
        address: String,
        image: String
    ) {
        val bundle = Bundle()
        bundle.putInt("sid",id)
        bundle.putString("sname",name)
        bundle.putInt("sage",age)
        bundle.putString("sgender",gender)
        bundle.putString("saddress",address)
        bundle.putString("simage",image)

        val transaction = this.supportFragmentManager.beginTransaction()
        val homeFragment = HomeFragment()
        homeFragment.arguments = bundle
        transaction.commit()
    }
}