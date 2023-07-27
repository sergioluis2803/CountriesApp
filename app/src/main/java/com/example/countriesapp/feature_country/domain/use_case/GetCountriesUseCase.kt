package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.feature_country.domain.model.Country
import com.example.countriesapp.feature_country.domain.repository.CountryApi

class GetCountriesUseCase(
    private val repository: CountryApi
) {

    suspend operator fun invoke(): List<Country>{
        return repository.getAllCountries()
    }
}