package com.platzi.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.platzi.platzistore.model.PayloadItem
import com.platzi.platzistore.model.ResponseProduct
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_landing.layoutManager = GridLayoutManager(this, 2)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://10.0.3.2:8080/") //Only when test in Genymotion device
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val endpoint = retrofit.create(Endpoints::class.java)

        val call = endpoint.getList()

        call.enqueue(object : Callback<ResponseProduct> {

            override fun onResponse(call: Call<ResponseProduct>?, response: Response<ResponseProduct>?) {
                if (response?.code() == 200) {
                    Log.i("Response", "${response.body().toString()}")

                    fillRecycler(response.body()?.payload)

                }
            }

            override fun onFailure(call: Call<ResponseProduct>?, t: Throwable?) {
                Log.e("Response", t.toString())
            }

        })

//        val itemsShop = (0..25).map {
//            ItemLanding("Titulo $it", "Descripcion $it", 200.00 + it, "")
//        }
//
//        val adapter = AdapterLanding(itemsShop)
//
//        rc_landing.adapter = adapter

    }

    private fun fillRecycler(payload: List<PayloadItem?>?) {
        val products = payload?.map {
            it?.let { (imgUrl, _, price, name, description) ->
                ItemLanding(name ?: "", description ?: "", price ?: 0.00, imgUrl ?: "")
            }
        }?.filter {
            val pr = it?.price ?:0.00
            pr > 205.00
        }

        rc_landing.adapter = AdapterLanding(products)
    }
}
