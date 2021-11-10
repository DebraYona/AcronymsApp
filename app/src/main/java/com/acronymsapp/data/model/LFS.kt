package com.acronymsapp.data.model

import com.google.gson.annotations.SerializedName

data class LFS(
    @SerializedName("lf") val abbreviation: String,
    @SerializedName("freq") val frequency: Int,
    @SerializedName("since") val since: Int,
    @SerializedName("vars") val variations: List<Variation>
)
