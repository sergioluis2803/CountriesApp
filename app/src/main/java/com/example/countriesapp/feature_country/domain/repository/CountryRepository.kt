package com.example.countriesapp.feature_country.domain.repository

import com.example.countriesapp.feature_country.data.data_source.CountryApiService
import com.example.countriesapp.feature_country.domain.model.CountryModel
import com.example.countriesapp.feature_country.domain.model.DetailCountry
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val api: CountryApiService
) {

    suspend fun getAllCountries(): List<CountryModel> {
        return api.getAllCountries()
    }

    suspend fun getCountryDescription(nameCountry: String): DetailCountry {
        return api.getCountryDescription(nameCountry)
    }
}