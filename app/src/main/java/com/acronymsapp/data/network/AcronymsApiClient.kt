package com.acronymsapp.data.network

import com.acronymsapp.data.model.AcronymsResponse
import retrofit2.http.*
import retrofit2.Response

interface AcronymsApiClient {
    @GET("dictionary.py")
    suspend fun getAcronyms(
        @Query("sf") acronym: String,
        @Query("if") fullforms: String,

    ): Response<List<AcronymsResponse>>

}