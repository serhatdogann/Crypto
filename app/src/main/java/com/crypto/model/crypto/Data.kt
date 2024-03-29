package com.crypto.model.crypto


import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("infinite_supply")
    val infiniteSupply: Boolean?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("max_supply")
    val maxSupply: Long?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("num_market_pairs")
    val numMarketPairs: Int?,
    @SerializedName("platform")
    val platform: Platform?,
    @SerializedName("quote")
    val quote: Quote?,
    @SerializedName("self_reported_circulating_supply")
    val selfReportedCirculatingSupply: Double?,
    @SerializedName("self_reported_market_cap")
    val selfReportedMarketCap: Double?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: List<String?>?,
    @SerializedName("total_supply")
    val totalSupply: Double?,
    @SerializedName("tvl_ratio")
    val tvlRatio: Double?,
    @SerializedName("isFavorite")
    var isFavorite:Boolean

)