package com.acronymsapp.data.network

import com.acronymsapp.data.model.AcronymsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AcronymsService @Inject constructor(private  val  api:AcronymsApiClient){


    suspend fun getAcronyms(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse> {
        return withContext(Dispatchers.IO){
            val response =
                api.getAcronyms(acronym, fullforms)
            response.body() ?: emptyList()
        }

    }


}