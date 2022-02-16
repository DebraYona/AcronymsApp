package com.acronymsapp.data.model

import com.google.gson.annotations.SerializedName

data class AcronymsResponse(
    @SerializedName("sf") val abbreviation: String,
    @SerializedName("lfs") val fullForms: List<LFS>,
)
