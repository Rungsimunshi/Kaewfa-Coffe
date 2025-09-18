package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Handle Bottom Navigation Bar clicks
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.navigation_profile // Highlight the Profile icon
        bottomNavigationView.setOnItemSelectedListener { item -> // เปลี่ยนเป็น setOnItemSelectedListener
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, Home1::class.java))
                    true
                }
                R.id.navigation_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.navigation_history -> {
                    val intent = Intent(this, PointsActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    }
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    // คุณอยู่ในหน้านี้แล้ว
                    true
                }
                else -> false
            }
        }

        // Handle Sign out click
        val signOutLayout = findViewById<LinearLayout>(R.id.sign_out_layout)
        signOutLayout.setOnClickListener {
            // Implement sign out logic here
        }

        // Handle FAB click
        val fabButton = findViewById<FloatingActionButton>(R.id.fab)
        if (fabButton != null) {
            fabButton.setOnClickListener {
                val intent = Intent(this, RedemptionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}