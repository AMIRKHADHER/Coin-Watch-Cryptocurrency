package com.apps.coinwhatchcryptocurrency.data.source.local.model

import com.google.gson.annotations.SerializedName

data class CoinsApiModel(
    @SerializedName("data")
    val coinsData: CoinsData?
)