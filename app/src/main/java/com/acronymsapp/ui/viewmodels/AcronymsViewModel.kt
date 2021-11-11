package com.acronymsapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acronymsapp.data.domain.GetAcronyms
import com.acronymsapp.data.model.AcronymsResponse
import com.acronymsapp.data.model.LFS
import kotlinx.coroutines.launch
import retrofit2.Response

class AcronymsViewModel : ViewModel() {
    var acronyms: MutableLiveData<List<LFS>?> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()


    var getAcronyms = GetAcronyms()

    fun onCreate(
        acronym: String,
        fullforms: String
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAcronyms(acronym, fullforms)
            Log.i("Request result", result.toString())

            if (!result.isNullOrEmpty()) {
                acronyms.value = result[0].fullForms
            } else {
                acronyms.value = emptyList()
            }
            
            isLoading.postValue(false)

        }
    }
}