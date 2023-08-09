package com.example.countriesapp.data

import com.example.countriesapp.data.data_source.CountryApiService
import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.data.model.DetailCountry
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