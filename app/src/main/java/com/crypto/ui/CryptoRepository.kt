package com.crypto.ui

import com.crypto.base.BaseRepository
import com.crypto.network.ApiFactory
import javax.inject.Inject

class CryptoRepository @Inject constructor(private val apiFactory: ApiFactory):BaseRepository() {

    suspend fun getData(apiKey:String,limit:String
    )=safeApiRequest{
        apiFactory.getData(apiKey,limit)
    }

}