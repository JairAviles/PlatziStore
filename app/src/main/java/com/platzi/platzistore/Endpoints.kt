package com.platzi.platzistore

import com.platzi.platzistore.model.ResponseProduct
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {
    @GET("list")
    fun getList() : Call<ResponseProduct>
}