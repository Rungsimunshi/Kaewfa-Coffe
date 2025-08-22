package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class createaccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_createaccount)

        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.create)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBackLogin = findViewById<MaterialButton>(R.id.btngotoregister)
        btnBackLogin.setOnClickListener {
            startActivity(Intent(this, Login3::class.java))
            finish()
        }
    }
}
