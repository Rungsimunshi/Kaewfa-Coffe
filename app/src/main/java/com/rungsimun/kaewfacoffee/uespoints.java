package com.rungsimun.kaewfacoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class uespoints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uespoints);

        // ตั้งค่าปุ่มย้อนกลับ
        ImageButton backButton = findViewById(R.id.backButton);
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }

        // ตั้งค่าปุ่ม "รับ"
        Button confirmButton = findViewById(R.id.confirmButton);
        if (confirmButton != null) {
            confirmButton.setOnClickListener(v -> {
                Toast.makeText(this, "รายการถูกยืนยันแล้ว", Toast.LENGTH_SHORT).show();
            });
        }

        // ตั้งค่าปุ่ม "ยกเลิก"
        Button cancelButton = findViewById(R.id.cancelButton);
        if (cancelButton != null) {
            cancelButton.setOnClickListener(v -> {
                Toast.makeText(this, "รายการถูกยกเลิกแล้ว", Toast.LENGTH_SHORT).show();
            });
        }
    }
}