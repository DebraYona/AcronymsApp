package com.acronymsapp.data.model

import com.google.gson.annotations.SerializedName

data class Variation(
    @SerializedName("lf") val abbreviation: String,
    @SerializedName("freq") val frequency: Int,
    @SerializedName("since") val since: Int
)
