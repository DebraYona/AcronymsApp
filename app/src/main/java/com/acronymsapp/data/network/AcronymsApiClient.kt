package com.acronymsapp.data.network

import com.acronymsapp.data.model.AcronymsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymsApiClient {
    @GET("dictionary.py")
    suspend fun getAcronyms(
        @Query("sf") acronym: String,
        @Query("if") fullforms: String,

        ): Response<List<AcronymsResponse>>

}