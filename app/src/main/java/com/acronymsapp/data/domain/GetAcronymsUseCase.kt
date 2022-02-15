package com.acronymsapp.data.domain

import com.acronymsapp.data.model.AcronymsResponse
import com.acronymsapp.data.repository.AcronymsRepository
import javax.inject.Inject

class GetAcronymsUseCase @Inject constructor(private val repository: AcronymsRepository) {

    suspend operator fun invoke(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse>? = repository.getAllAcronymsRepository(acronym, fullforms)

}