package com.acronymsapp.data.network

import com.acronymsapp.api.RetrofitInstance
import com.acronymsapp.data.model.AcronymsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.http.Query

class AcronymsService {

    private val retrofit = RetrofitInstance.getRetrofit()

    suspend fun getAcronyms(
        acronym: String,
        fullforms: String
    ): List<AcronymsResponse> {
        return withContext(Dispatchers.IO){
            val response =
                retrofit.create(AcronymsApiClient::class.java).getAcronyms(acronym, fullforms)
            response.body() ?: emptyList()
        }

    }


}