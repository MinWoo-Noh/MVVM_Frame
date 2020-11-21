package com.example.levelupproject.retrofitclient

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    private var instance : Retrofit? = null

    fun getInstnace() : Retrofit {
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl("https://sapic-sprint.brandi.me/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!! // !!는 절때 null이 아니다 null이면 앱을 죽인다.
    }
}