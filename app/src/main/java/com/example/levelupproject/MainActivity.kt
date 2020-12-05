package com.example.levelupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupproject.apiinterface.APIinterface
import com.example.levelupproject.retrofitclient.ProductWithCouponData
import com.example.levelupproject.retrofitclient.RetrofitClient
import com.example.levelupproject.ui.ProdutFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction() // 프래그먼트 관리자를 통한 제어프
        fragmentTransaction.add(R.id.fragment_container, ProdutFragment())
        fragmentTransaction.commit()
    }
}