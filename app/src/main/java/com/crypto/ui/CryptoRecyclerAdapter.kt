package com.crypto.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crypto.databinding.RecyclerRowLayoutBinding
import com.crypto.model.crypto.Data


class CryptoRecyclerAdapter(private val listener: ItemClickListener) : RecyclerView.Adapter<CryptoRecyclerAdapter.CryptoViewHolder>() {

    private var coins = mutableListOf<Data>()

    inner class CryptoViewHolder(private val binding: RecyclerRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Data) {
            binding.coin = coin
            binding.executePendingBindings()

            binding.imgstar.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedCoin = coins[position]
                    clickedCoin.isFavorite = !clickedCoin.isFavorite
                    notifyItemChanged(position)
                    listener.onItemClick(clickedCoin)
                }
            }

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedCoin = coins[position]
                    listener.onItemClick(clickedCoin)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerRowLayoutBinding.inflate(layoutInflater, parent, false)
        return CryptoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val coin = coins[position]
        holder.bind(coin)
    }

    fun setCoinsList(newList: List<Data>) {
        coins.clear()
        coins.addAll(newList)
        notifyDataSetChanged()
    }
}
