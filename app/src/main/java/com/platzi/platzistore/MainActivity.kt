package com.platzi.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_landing.layoutManager = GridLayoutManager(this, 2)

        val itemsShop = (0..25).map {
            ItemLanding("Titulo $it", "Descripcion $it", 200.00 + it)
        }

        val adapter = AdapterLanding(itemsShop)

        rc_landing.adapter = adapter

    }
}
