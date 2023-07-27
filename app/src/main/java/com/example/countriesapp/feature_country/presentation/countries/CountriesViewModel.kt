package com.example.countriesapp.feature_country.presentation.countries

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.di.RetrofitHelper
import com.example.countriesapp.feature_country.domain.model.Country
import com.example.countriesapp.feature_country.domain.repository.CountryApi
import com.example.countriesapp.feature_country.domain.use_case.GetCountriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.Exception

class CountriesViewModel : ViewModel() {

    private val repository: CountryApi = RetrofitHelper.instance
    private val countriesUseCase = GetCountriesUseCase(repository)

    private val _allCountries = mutableStateOf<List<Country>>(emptyList())
    private val allCountries: List<Country> get() = _allCountries.value

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _filterCountry = mutableStateOf<List<Country>>(emptyList())
    val filterCountry: List<Country> get() = _filterCountry.value

    fun getCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = countriesUseCase.invoke()
                if (result.isNotEmpty()) {
                    _allCountries.value = result
                    filterCountries(_searchQuery.value)
                }
            } catch (error: Exception) {
                Log.d("ERROR", "error en list")
            }

        }
    }

    private fun filterCountries(query: String) {
        _filterCountry.value = if (query.isEmpty()) {
            allCountries
        } else {
            allCountries.filter { country ->
                country.name.common.lowercase().contains(query.lowercase())
            }
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
        filterCountries(query)
    }

}