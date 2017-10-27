package com.platzi.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_desc.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val db = DBOpenHelper.getInstance(this)

        intent?.extras?.let {
            val title = it.getString("title")
            val descr = it.getString("desc")
            val price = it.getDouble("price")

            detail_title.text = title
            detail_desc.text = descr
            detail_price.text = "$ ${String.format("%.2f", price)}"

            btn_detail_buy.setOnClickListener {
                db?.use {
                    val namePr = "name" to title
                    val descPr = "desc" to descr
                    val pricePr = "price" to price
                    insert("Products", namePr, descPr, pricePr)
                }
                startActivity<ShopCartActivity>()
            }

        }

    }
}
