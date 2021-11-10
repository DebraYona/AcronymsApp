package com.acronymsapp.data.repository

import com.acronymsapp.data.model.AcronymsResponse
import com.acronymsapp.data.network.AcronymsService
import retrofit2.Response

class AcronymsRepository {
    private val api = AcronymsService()

    suspend fun getAllAcronyms(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse> {
        return api.getAcronyms(acronym, fullforms)
    }

}