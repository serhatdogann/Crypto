package com.crypto.BindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.crypto.utils.load

class CoinBinding {

    //https://s2.coinmarketcap.com/static/img/coins/64x64/27009.png

    companion object{

        @BindingAdapter("load")
        @JvmStatic
        fun loadImage(imageview:ImageView,coinImage:String?){
            val imageurl="https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
            imageview.load(imageurl)
        }
    }
}