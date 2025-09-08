package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Find views from the layout
        val backArrow: ImageView = findViewById(R.id.backArrow)
        val detailImage: ImageView = findViewById(R.id.detail_image)
        val detailName: TextView = findViewById(R.id.detail_name)
        val detailDescription: TextView = findViewById(R.id.detail_description)
        val detailPrice: TextView = findViewById(R.id.detail_price)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set up the back button click listener
        backArrow.setOnClickListener {
            onBackPressed() // Use onBackPressed() to navigate back
        }

        // Set up the bottom navigation click listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Navigate to Home1 and clear other activities
                    val intent = Intent(this, Home1::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                    true
                }
                R.id.navigation_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true

                }
                R.id.navigation_profile -> {
                    // Navigate to ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Retrieve data from Intent
        val imageResId = intent.getIntExtra("image_res_id", -1)
        val name = intent.getStringExtra("name") ?: "No name"
        val description = intent.getStringExtra("description") ?: "No description"
        val price = intent.getStringExtra("price") ?: "฿ 0"

        // Display the data
        if (imageResId != -1) {
            detailImage.setImageResource(imageResId)
        }
        detailName.text = name
        detailDescription.text = description
        detailPrice.text = price
    }
}