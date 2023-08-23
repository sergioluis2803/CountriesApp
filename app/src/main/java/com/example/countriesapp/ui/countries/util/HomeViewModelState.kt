package com.example.countriesapp.ui.countries.util

import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.util.ErrorMessage

data class HomeViewModelState(
    val filterCountry: List<CountryModel> = emptyList(),
    val listCountries: List<CountryModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList(),
    val searchInput: String = "",
) {
    fun toUiState(): HomeUiState = if (listCountries.isEmpty()) {
        HomeUiState.NoCountries(
            isLoading = isLoading,
            errorMessage = errorMessages,
            searchInput = searchInput
        )
    } else {
        HomeUiState.HasCountries(
            filterCountry = filterCountry,
            listCountries = listCountries,
            isLoading = isLoading,
            errorMessage = errorMessages,
            searchInput = searchInput
        )
    }

}

