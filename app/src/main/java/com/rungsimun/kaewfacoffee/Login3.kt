package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login3 : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, login2::class.java))
        }

        val btnCreate = findViewById<Button>(R.id.btnCreate)
        btnCreate.setOnClickListener {
            startActivity(Intent(this, createaccount::class.java))
        }

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val ivTogglePassword = findViewById<ImageView>(R.id.ivTogglePassword)

        ivTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                // ซ่อนรหัสผ่าน
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_view) // ตาปิด
                isPasswordVisible = false
            } else {
                // แสดงรหัสผ่าน
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_hide) // ตาเปิด
                isPasswordVisible = true
            }
            // ให้ cursor อยู่ท้ายสุด
            etPassword.setSelection(etPassword.text.length)
        }
    }
}
