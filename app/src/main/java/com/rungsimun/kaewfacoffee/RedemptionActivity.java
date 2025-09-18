package com.rungsimun.kaewfacoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import com.rungsimun.kaewfacoffee.ProductAdapter.OnItemClickListener;

public class RedemptionActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem);

        // ตั้งค่าปุ่มย้อนกลับ
        ImageButton backButton = findViewById(R.id.backButton);
        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }

        // ตั้งค่า RecyclerView สำหรับรายการสินค้า
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(this, 2));

        // สร้างข้อมูลสินค้าตัวอย่าง
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.blue_hawaii_soda, "Blue Hawaii Soda", "แลกซื้อด้วยคะแนน", "100 pts"));
        productList.add(new Product(R.drawable.milk_green_tea, "Milk Green Tea", "แลกซื้อด้วยคะแนน", "100 pts"));
        productList.add(new Product(R.drawable.iced_latte, "Iced Latte", "แลกซื้อด้วยคะแนน", "100 pts"));
        productList.add(new Product(R.drawable.caffe_mocha, "Caffe Mocha", "แลกซื้อด้วยคะแนน", "100 pts"));

        // กำหนด Adapter ให้กับ RecyclerView พร้อมส่ง this (Activity) เป็น listener
        productAdapter = new ProductAdapter(productList, this);
        recyclerViewProducts.setAdapter(productAdapter);

        // ตั้งค่า Bottom Navigation View และ Floating Action Button
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_search);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(RedemptionActivity.this, Home1.class));
                return true;
            } else if (itemId == R.id.navigation_search) {
                return true;
            } else if (itemId == R.id.navigation_history) {
                startActivity(new Intent(RedemptionActivity.this, PointsActivity.class));
                return true;
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(RedemptionActivity.this, ProfileActivity.class));
                return true;
            }
            return false;
        });

        FloatingActionButton fabButton = findViewById(R.id.fab);
        if (fabButton != null) {
            fabButton.setOnClickListener(v -> {
                // เปิดหน้าสแกน QR หรือหน้าที่คุณต้องการ
                // startActivity(new Intent(RedemptionActivity.this, ScanQRActivity.class));
            });
        }
    }

    // This method is called when an item in the RecyclerView is clicked
    @Override
    public void onItemClick(int position) {
        Product selectedProduct = productList.get(position);

        // แก้ไข Intent เพื่อเปิด uespoints.class
        Intent intent = new Intent(this, uespoints.class);

        // ส่งข้อมูลสินค้าที่ถูกเลือกไปยังหน้า uespoints
        intent.putExtra("product_name", selectedProduct.getName());
        intent.putExtra("product_image", selectedProduct.getImageResId());
        intent.putExtra("product_price", selectedProduct.getPrice());
        startActivity(intent);
    }
}