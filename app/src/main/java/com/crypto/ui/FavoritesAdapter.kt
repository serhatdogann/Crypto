package com.crypto.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crypto.databinding.RecyclerRowLayoutBinding
import com.crypto.model.crypto.Data


class FavoritesAdapter(private var dataList: List<Data>, private val listener: ItemClickListener) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerRowLayoutBinding.inflate(inflater, parent, false)
        return FavoriteViewHolder(binding)
    }

    fun updateData(newData: List<Data>) {
        dataList = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class FavoriteViewHolder(private val binding: RecyclerRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.coin = data
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                listener.onItemClick(data)
            }
        }
    }
}
