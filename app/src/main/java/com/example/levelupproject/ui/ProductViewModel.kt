package com.example.levelupproject.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.levelupproject.apiinterface.APIinterface
import com.example.levelupproject.retrofitclient.ProductWithCouponData
import com.example.levelupproject.retrofitclient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    // guest 토큰
    private val auth = "3b17176f2eb5fdffb9bafdcc3e4bc192b013813caddccd0aad20c23ed272f076_1423639497"

    // koin 으로 의존성 주입 받아야함.
    // retrofit
    val retrofit = RetrofitClient.getInstnace()
    val apiInterface = retrofit.create(APIinterface::class.java)

    private val _productWithCouponData = MutableLiveData<ProductWithCouponData?>()
    val productWithCouponData: LiveData<ProductWithCouponData?>
        get() = _productWithCouponData

    fun getProductWithCoupon() {
        // RxJava나, Coroutine 사용으로 바꿀 예정
        Runnable {
            apiInterface.getProductsWithCoupon(auth)
                .enqueue(object : Callback<ProductWithCouponData?> {
                    override fun onResponse(
                        call: Call<ProductWithCouponData?>,
                        response: Response<ProductWithCouponData?>
                    ) {
                        _productWithCouponData.postValue(response.body())
                    }

                    override fun onFailure(call: Call<ProductWithCouponData?>, t: Throwable) {
                        Log.d("test!!", t.message ?: "error ~~~ ")
                    }
                })
        }.run()
    }
}