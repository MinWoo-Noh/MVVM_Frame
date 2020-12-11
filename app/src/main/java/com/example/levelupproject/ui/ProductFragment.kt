package com.example.levelupproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupproject.R
import com.example.levelupproject.RecyclerViewAdapter
import com.example.levelupproject.retrofitclient.ProductWithCouponData
import org.koin.android.viewmodel.ext.android.viewModel

class ProductFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.frag_fragment, container, false)

        viewModel.productWithCouponData.observe(
            this,
            Observer {
                if (it != null) {
                    val recycleView: RecyclerView =
                        rootView.findViewById(R.id.recycleView) as RecyclerView
                    val adapter = RecyclerViewAdapter(it.data.products)
                    recycleView.adapter = adapter
                }
            })

        viewModel.getProductWithCoupon()

        return rootView
    }
}
