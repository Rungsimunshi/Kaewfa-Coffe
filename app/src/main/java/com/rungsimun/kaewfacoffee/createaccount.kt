package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class createaccount : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_createaccount)

        // ตั้งค่า padding ตาม systemBars
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.create)
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ปุ่มไปหน้า Login
        val btnBackLogin = findViewById<MaterialButton>(R.id.btngotoregister)
        btnBackLogin.setOnClickListener {
            startActivity(Intent(this, Login3::class.java))
            finish()
        }

        // เปิด/ปิดรหัสผ่าน
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val ivTogglePassword = findViewById<ImageView>(R.id.ivTogglePassword)

        ivTogglePassword.setOnClickListener {
            if (isPasswordVisible) {
                // ซ่อนรหัสผ่าน
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_hide) // ตาปิด
                isPasswordVisible = false
            } else {
                // แสดงรหัสผ่าน
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_view) // ตาเปิด
                isPasswordVisible = true
            }
            // ให้ cursor อยู่ท้ายสุด
            etPassword.setSelection(etPassword.text.length)
        }
    }
}
