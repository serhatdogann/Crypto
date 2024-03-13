package com.crypto.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crypto.R
import com.crypto.ui.FavoritesAdapter
import com.crypto.ui.ItemClickListener
import com.crypto.model.crypto.Data
import com.crypto.ui.FavoriViewModel

class FavotiresFragment : Fragment() {
    private lateinit var favoritesAdapter: FavoritesAdapter
    private lateinit var recyclerView: RecyclerView
    private val favoriViewModel: FavoriViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_favotires, container, false)
        recyclerView = rootView.findViewById(R.id.fvrtsRecycler)

        // RecyclerView için boş bir adapter oluşturun ve bağlayın
        favoritesAdapter = FavoritesAdapter(emptyList(), object : ItemClickListener {
            override fun onItemClick(coin: Data) {
                // Tıklama olayını işlemek için buraya kodlarınızı ekleyin
                // Örneğin, tıklanan öğeyle ilgili bir işlem yapabilirsiniz
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = favoritesAdapter

        favoriViewModel.getFavoriList().observe(viewLifecycleOwner, { favoriList ->
            Log.d("FAVORITE_LOG", "Favori listesi güncellendi: $favoriList")
            favoritesAdapter.updateData(favoriList.toList())
            favoritesAdapter.notifyDataSetChanged()
        })


        return rootView
    }
}
