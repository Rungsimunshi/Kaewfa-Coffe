package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Find views by their IDs
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val notificationButton: FrameLayout = findViewById(R.id.notification_button)
        val fabButton: FloatingActionButton = findViewById(R.id.fab)

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
                    // อยู่ในหน้านี้แล้ว ไม่ต้องทำอะไร
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
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    }
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // ตั้งค่าให้ไอคอน Search ถูกไฮไลต์
        bottomNavigationView.selectedItemId = R.id.navigation_search

        // Listener for Notification Button
        notificationButton.setOnClickListener {
            // Placeholder: Replace with your NewsActivity
            val intent = Intent(this, NewsActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            }
            startActivity(intent)
        }

        // Listener for Floating Action Button
        fabButton.setOnClickListener {
            val intent = Intent(this, RedemptionActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            }
            startActivity(intent)
        }
    }
}