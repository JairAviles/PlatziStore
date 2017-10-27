package com.platzi.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_shop_cart.*
import org.jetbrains.anko.db.select

class ShopCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_cart)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rc_cart.layoutManager = layoutManager
        rc_cart.setHasFixedSize(true)

        val items = arrayListOf<ItemLanding>()

        (0..2).map { items.add(ItemLanding("Item $it", "Desc $it", it + 100.0, "")) }

        rc_cart.adapter = AdapterCart(items)

    }

    override fun onResume() {
        super.onResume()
        val db = DBOpenHelper.getInstance(this)
        db?.use {
            select("Products").exec {
                Log.e("Columnas:", "${this.columnCount}")
                Log.e("Columnas:", "${this.columnNames.size}")

                (this.columnNames).map {
                    Log.d("Columna: ", "$it")
                    Log.d("Columna: ", "${this.getColumnIndex(it)}")
                    Log.d("Columna: ", "$ ${this.getColumnName(this.getColumnIndex(it))}")
                }

                this.moveToFirst()
                do {
                    Log.d("VALUE", this.getString(1) ?: "")
                    Log.d("VALUE", this.getString(2) ?: "")
                    Log.d("VALUE", "$ ${this.getDouble(3)}")
                } while (this.moveToNext())

            }
        }
    }
}
