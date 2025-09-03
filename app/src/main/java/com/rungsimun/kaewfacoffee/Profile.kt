package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Handle Bottom Navigation Bar clicks
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.navigation_profile // Highlight the Profile icon
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, Home1::class.java))
                    finish()
                    true
                }
                R.id.navigation_search -> {
                    // Navigate to Search screen
                    true
                }
                R.id.navigation_history -> {
                    // Navigate to History screen
                    true
                }
                R.id.navigation_profile -> {
                    // You are already on this screen
                    true
                }
                else -> false
            }
        }

        // Handle Sign out click
        val signOutLayout = findViewById<LinearLayout>(R.id.sign_out_layout)
        signOutLayout.setOnClickListener {
            // Implement sign out logic here
            // Example:
            // val intent = Intent(this, Login3::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            // startActivity(intent)
        }
    }
}