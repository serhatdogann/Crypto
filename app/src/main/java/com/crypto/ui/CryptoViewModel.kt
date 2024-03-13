package com.crypto.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crypto.model.crypto.CryptoResponse
import com.crypto.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CryptoViewModel @Inject constructor(private val repository: CryptoRepository) : ViewModel() {

    val cryptoResponse: MutableLiveData<CryptoResponse> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val onError: MutableLiveData<String?> = MutableLiveData()


    fun getData(apiKey: String, limit: String) {
        viewModelScope.launch {
            isLoading.value = true
            val request = repository.getData(apiKey, limit)

            when (request) {
                is NetworkResults.Success<*> -> {
                    cryptoResponse.value = request.data as CryptoResponse
                    isLoading.value = false
                }
                is NetworkResults.Error<*> -> {
                    onError.value = request.message
                    isLoading.value = false
                }
            }
        }
    }
}
