package com.rungsimun.kaewfacoffee

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.featured_recycler_view)

        val productList = ArrayList<Product>()
        productList.add(Product(R.drawable.blue_hawaii_soda, "Blue Hawaii Soda", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55")) // <-- แก้ไขตรงนี้
        productList.add(Product(R.drawable.milk_green_tea, "Milk Green Tea", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.iced_latte, "Iced Latte", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.caffe_mocha, "Caffe Mocha", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.blended_fresh_milk, "Blended Fresh Milk", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.yogurt_blue_sky, "Yogurt Blue Sky", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.yogurt_pink_sky, "Yogurt Pink Sky", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.hot_espresso, "Hot Espresso", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.hot_green_tea, "Hot Green Tea", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))
        productList.add(Product(R.drawable.hot_latte, "Hot Latte", "กดเพื่อดูข้อมูลเพิ่มเติม", "฿ 55"))

        val adapter = ProductAdapter(productList)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = adapter
    }
}