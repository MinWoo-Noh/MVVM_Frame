package com.example.levelupproject.apiinterface

import com.example.levelupproject.retrofitclient.ProductWithCouponData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIinterface {

    @GET("coupon/38723/products?limit=30&offset=0&is-first=true")
    fun getProductsWithCoupon(@Header("Authorization") auth: String): Call<ProductWithCouponData>

}