package com.example.levelupproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.levelupproject.R
import com.example.levelupproject.RecyclerViewAdapter
import com.example.levelupproject.apiinterface.APIinterface
import com.example.levelupproject.retrofitclient.ProductWithCouponData
import com.example.levelupproject.retrofitclient.RetrofitClient
import com.example.levelupproject.utils.inflate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.frag_fragment, container, false)

        // retrofit
        val retrofit = RetrofitClient.getInstnace()
        val apIinterface = retrofit.create(APIinterface::class.java)

        // Runnable 은 새로운 쓰래드를 만드는것.
        // 동기 비동기
        Runnable {
            apIinterface.getProductsWithCoupon("3550060.2e087d9a384aacbce168dce7d0f82060.1603764064")
                .enqueue(object : Callback<ProductWithCouponData?> {
                    override fun onFailure(call: Call<ProductWithCouponData?>, t: Throwable) {
                        Log.d("test!!", t.message ?: "error ~~~ ")
                    }

                    override fun onResponse(
                        call: Call<ProductWithCouponData?>,
                        response: Response<ProductWithCouponData?>
                    ) {
//                        val datas = ArrayList<ProductWithCouponData.DataBean.ProductsBean>()
//                        datas.add(response.body()!!.data)
                        // recycleView

                        val recycleView: RecyclerView = rootView.findViewById(R.id.recycleView) as RecyclerView
                        val adapter = RecyclerViewAdapter(response.body()!!.data.products)
                        recycleView.adapter = adapter
                    }
                })
        }.run()

        return rootView
    }
}
