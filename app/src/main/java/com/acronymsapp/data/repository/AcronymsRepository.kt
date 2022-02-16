package com.acronymsapp.data.repository

import com.acronymsapp.data.model.AcronymsResponse
import com.acronymsapp.data.network.AcronymsService
import javax.inject.Inject

class AcronymsRepository @Inject constructor(private val api: AcronymsService) {

    suspend fun getAllAcronymsRepository(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse> {
        return api.getAcronyms(acronym, fullforms)
    }

}