package com.rungsimun.kaewfacoffee

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Home1 : AppCompatActivity(), ProductAdapter.OnItemClickListener {
    private lateinit var productList: ArrayList<Product>

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.featured_recycler_view)
        productList = ArrayList()
        productList.add(Product(R.drawable.blue_hawaii_soda, "Blue Hawaii Soda", "น้ำโซดาซ่าเย็น ผสมกลิ่นหอมหวานของบลูฮาวายและมะนาวอย่างลงตัว", "฿ 55"))
        productList.add(Product(R.drawable.milk_green_tea, "Milk Green Tea", "ชาเขียวนมรสชาติกลมกล่อม หอมชาเขียวแท้ๆ", "฿ 55"))
        productList.add(Product(R.drawable.iced_latte, "Iced Latte", "กาแฟลาเต้เย็น รสชาติละมุนลิ้น", "฿ 55"))
        productList.add(Product(R.drawable.caffe_mocha, "Caffe Mocha", "กาแฟมอคค่า รสชาติเข้มข้น หอมช็อกโกแลต", "฿ 55"))
        productList.add(Product(R.drawable.blended_fresh_milk, "Blended Fresh Milk", "นมสดปั่นละเอียด หวานมันชื่นใจ", "฿ 55"))
        productList.add(Product(R.drawable.yogurt_blue_sky, "Yogurt Blue Sky", "โยเกิร์ตปั่นกับบลูฮาวาย ได้รสชาติเปรี้ยวหวานสดชื่น", "฿ 55"))
        productList.add(Product(R.drawable.yogurt_pink_sky, "Yogurt Pink Sky", "โยเกิร์ตปั่นกับไซรัปสตรอว์เบอร์รี หวานอมเปรี้ยว", "฿ 55"))
        productList.add(Product(R.drawable.hot_espresso, "Hot Espresso", "เอสเปรสโซ่ร้อน รสชาติเข้มข้น", "฿ 55"))
        productList.add(Product(R.drawable.hot_green_tea, "Hot Green Tea", "ชาเขียวร้อน รสกลมกล่อม", "฿ 55"))
        productList.add(Product(R.drawable.hot_latte, "Hot Latte", "ลาเต้ร้อน หอมนมและกาแฟ", "฿ 55"))

        val adapter = ProductAdapter(productList, this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_search -> {
                    val intent = Intent(this, SearchActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    }
                    startActivity(intent)
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

        // ทำให้ปุ่ม QR code กดได้และเปลี่ยนไปหน้า RedemptionActivity
        val fabButton = findViewById<FloatingActionButton>(R.id.fab)
        fabButton.setOnClickListener {
            val intent = Intent(this, RedemptionActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            }
            startActivity(intent)
        }
    }

    override fun onItemClick(position: Int) {
        val selectedProduct = productList[position]
        val intent = Intent(this, Detail::class.java)
        intent.putExtra("image_res_id", selectedProduct.imageResId)
        intent.putExtra("name", selectedProduct.name)
        intent.putExtra("description", selectedProduct.description)
        intent.putExtra("price", selectedProduct.price)
        startActivity(intent)
    }
}