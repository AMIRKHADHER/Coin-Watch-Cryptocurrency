package com.apps.coinwhatchcryptocurrency.data.source.local.model

import com.google.gson.annotations.SerializedName

data class CoinsData(
    @SerializedName("coins")
    val coins: List<CoinApiModel?>?
)