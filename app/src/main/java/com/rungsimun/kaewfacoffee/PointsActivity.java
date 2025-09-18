package com.rungsimun.kaewfacoffee;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_home);

        // 1. ทำให้ปุ่ม "Exchange" กดได้และเปลี่ยนไปหน้า RedemptionActivity
        Button exchangeButton = findViewById(R.id.button_exchange);
        if (exchangeButton != null) {
            exchangeButton.setOnClickListener(v -> {
                Intent intent = new Intent(PointsActivity.this, RedemptionActivity.class);
                startActivity(intent);
            });
        }

        // 2. ทำให้ "Update now" กดได้
        TextView updateTextView = findViewById(R.id.textView_update);
        if (updateTextView != null) {
            updateTextView.setOnClickListener(v -> {
                // เมื่อข้อความถูกกด จะแสดงข้อความ
                Toast.makeText(this, "ข้อมูลกำลังอัปเดต...", Toast.LENGTH_SHORT).show();
            });
        }

        // 3. ทำให้ Floating Action Button (fab) กดได้และเปลี่ยนไปหน้า RedemptionActivity
        FloatingActionButton fabButton = findViewById(R.id.fab);
        if (fabButton != null) {
            fabButton.setOnClickListener(v -> {
                Intent intent = new Intent(PointsActivity.this, RedemptionActivity.class);
                startActivity(intent);
            });
        }

        // 4. ทำให้ BottomNavigationView กดไปหน้าอื่นได้
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // กำหนดเมนูที่ถูกเลือกในปัจจุบันให้เป็น "History" (ตามรูปที่ให้มา)
        bottomNavigationView.setSelectedItemId(R.id.navigation_history);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                Intent intent = new Intent(PointsActivity.this, Home1.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_search) {
                Intent intent = new Intent(PointsActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_history) {
                // อยู่ในหน้านี้แล้ว ไม่ต้องทำอะไร
                return true;
            } else if (itemId == R.id.navigation_profile) {
                Intent intent = new Intent(PointsActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}