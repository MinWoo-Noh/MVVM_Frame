package com.example.levelupproject.retrofitclient

data class ProductWithCouponData(
    var meta: MetaBean,
    var data: DataBean
) {

    data class MetaBean(
        var code: Int,
        var count: Int
    )

    data class DataBean(
        var total_count: String,
        var coupons: CouponsBean,
        var products : ArrayList<ProductsBean>
    ) {
        data class CouponsBean(

            var id: String,
            var name: String,
            var sale: SaleBean
        ) {
            data class SaleBean(
                var type: String,
                var value: Int
            )
        }

        data class ProductsBean(
            var id : Int,
            var image_thumbnai_url : String,
            var image_medium_url : String,
            var image_url : String,
            var name : String,
            var price : Int,
            var sale_price : Int
        )
    }

}