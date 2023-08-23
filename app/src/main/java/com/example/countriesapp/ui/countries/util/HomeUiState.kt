package com.example.countriesapp.ui.countries.util

import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.util.ErrorMessage

sealed interface HomeUiState {

    val isLoading: Boolean
    val errorMessage: List<ErrorMessage>
    val searchInput: String

    data class NoCountries(
        override val isLoading: Boolean,
        override val errorMessage: List<ErrorMessage>,
        override val searchInput: String
    ) : HomeUiState

    data class HasCountries(
        val filterCountry : List<CountryModel>,
        val listCountries : List<CountryModel>,
        override val isLoading: Boolean,
        override val errorMessage: List<ErrorMessage>,
        override val searchInput: String
    ) : HomeUiState

}