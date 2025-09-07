package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Find views by their IDs
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val notificationButton: FrameLayout = findViewById(R.id.notification_button)

        // Set the listener for when a menu item is selected
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, Home1::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    }
                    startActivity(intent)
                    true
                }
                R.id.navigation_search -> {
                    // Current activity, no action needed
                    true
                }
                R.id.navigation_profile -> {
                    // Placeholder: Replace with your ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    }
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Set the search icon as selected to match the UX
        bottomNavigationView.selectedItemId = R.id.navigation_search

        // Listener for Notification Button
        notificationButton.setOnClickListener {
            // Placeholder: Replace with your NewsActivity
            val intent = Intent(this, NewsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            }
            startActivity(intent)
        }

        // Apply window insets for full-screen mode
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
