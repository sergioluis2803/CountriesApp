package com.example.countriesapp.feature_country.presentation.util

sealed class Screen(val route: String) {
    object CountriesScreen: Screen("countries_screen")
    object DetailCountryScreen: Screen("detail_country_screen")
}