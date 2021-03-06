package com.acronymsapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acronymsapp.data.domain.GetAcronymsUseCase
import com.acronymsapp.data.model.LFS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcronymsViewModel @Inject constructor(
    private val getAcronymsUseCase: GetAcronymsUseCase
) : ViewModel() {
    var acronyms: MutableLiveData<List<LFS>?> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun onCreate(
        acronym: String,
        fullforms: String
    ) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAcronymsUseCase(acronym, fullforms)
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