package com.platzi.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_desc.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            detail_title.text = it.getString("title")
            detail_desc.text = it.getString("desc")
            detail_price.text = "$ ${String.format("%.2f", it.getDouble("price"))}"
        }

    }
}
