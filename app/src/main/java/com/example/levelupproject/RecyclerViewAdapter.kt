package com.example.levelupproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.levelupproject.retrofitclient.ProductWithCouponData

class RecyclerViewAdapter(private val items: ArrayList<ProductWithCouponData.DataBean.ProductsBean>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    // 보여줄 item 개수만큼 View를 생성해 준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflateView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(inflateView)
    }

    // 보여질 item의 개수가 몇개인지 알려준다.
    override fun getItemCount(): Int {
        return items.size
    }

    // 생성된 View에 보여줄 데이터를 설정(set) 해준다.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindViewHolder(item)
        //holder.tv_product_name.text = items[position].toString()
    }

    // inner 클래그로 선언된것도 있던데 inner클래스로 선언한것과 그냥 class 선언의 차이점 물어보기

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        // ViewHolder class는 RecyclerView 의 viewHolder를 상속 받는다
        // inflateView 를 받는다 ??
        private var view: View = v

        var iv_image = view.findViewById<ImageView>(R.id.iv_image)
        var tv_product_name = view.findViewById<TextView>(R.id.tv_product_name)
        var tv_price = view.findViewById<TextView>(R.id.tv_price)

        fun bindViewHolder(item: ProductWithCouponData.DataBean.ProductsBean) {
            // RecyclerView.xml 의 id와 ProductWithCouponData( 사용하고자하는 items)를 연결 해준다
            // 위 주석은 틀림, 변수 선언 및 파인드뷰만 해주면 된다.
            // viewHolder 을 쓰는 이유 : RecyclerView 를 사용하여 화면에 10개의 item 이 보여진다면 아래로 스크롤을 했을때
            // 1~10번째중 1번재가 11번째 가되면서 재사용을한다. 10개는 100개든 스크롤을 내리면서 재사용을 한다는 말이다,
            // 재사용을 하려면 10개의 뷰(보여지는 뷰)를 기억하고있을(홀당) 객체가 필요한데 이것이 viewHolder 아다.

            tv_product_name.text = item.name

        }

    }
}