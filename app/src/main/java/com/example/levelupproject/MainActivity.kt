package com.example.levelupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.levelupproject.ui.ProductFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction() // 프래그먼트 관리자를 통한 제어프
        fragmentTransaction.add(R.id.fragment_container, ProductFragment())
        fragmentTransaction.commit()
    }
}