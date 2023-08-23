package com.example.countriesapp.ui.countries

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.domain.use_case.GetCountriesUseCase
import com.example.countriesapp.ui.countries.util.HomeViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val countriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val viewModelState = MutableStateFlow(HomeViewModelState(isLoading = true))

    val uiState = viewModelState
        .map(HomeViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        refreshCountries()
    }

    fun refreshCountries() {
        viewModelState.update { it.copy(isLoading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = countriesUseCase.invoke()
                if (result.isNotEmpty()) {
                    viewModelState.update { it.copy(isLoading = false, listCountries = result, filterCountry = result) }
                    filterCountries(viewModelState.value.searchInput)
                }
            } catch (error: Exception) {
                Log.d("ERROR", "error en list")
            }
        }
    }

    private fun filterCountries(query: String) {
        val newList =  if (query.isEmpty()){
            viewModelState.value.listCountries
        }else{
            viewModelState.value.listCountries.filter {
                it.name.common.lowercase().contains(query.lowercase())
            }
        }

        viewModelState.update {
            it.copy(filterCountry = newList)
        }
    }

    fun setSearchQuery(query: String) {
        viewModelState.update {
            it.copy(searchInput = query)
        }
        filterCountries(query)
    }

}