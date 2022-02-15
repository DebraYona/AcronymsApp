package com.acronymsapp.data.domain

import com.acronymsapp.data.model.AcronymsResponse
import com.acronymsapp.data.repository.AcronymsRepository
import retrofit2.Response
import javax.inject.Inject

class GetAcronyms @Inject constructor(private val repository: AcronymsRepository) {

    suspend operator fun invoke(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse>? = repository.getAllAcronyms(acronym, fullforms)

}