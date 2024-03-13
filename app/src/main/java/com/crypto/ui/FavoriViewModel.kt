package com.crypto.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crypto.model.crypto.Data

class FavoriViewModel : ViewModel() {
    private val favoriList = MutableLiveData<MutableSet<Data>>()

    init {
        favoriList.value = mutableSetOf() // Boş bir set ile başlatılır.
    }

    // Favori öğelerini LiveData olarak dışarıya açan bir metod
    fun getFavoriList(): LiveData<MutableSet<Data>> {
        return favoriList
    }

    // Favori öğe ekleme metodu
    fun addToFavori(dataItem: Data) {
        val updatedList = favoriList.value ?: mutableSetOf()
        updatedList.add(dataItem)
        favoriList.value = updatedList
        Log.d("FAVORITE_LOG", "Favori eklendi: $dataItem") // Log mesajı ekle

    }

    // Favori öğe kaldırma metodu
    fun removeFromFavori(dataItem: Data) {
        val updatedList = favoriList.value ?: mutableSetOf()
        updatedList.remove(dataItem)
        favoriList.value = updatedList
    }
}
