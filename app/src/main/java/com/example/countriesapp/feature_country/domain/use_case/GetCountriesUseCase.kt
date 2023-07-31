package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.feature_country.domain.model.CountryModel
import com.example.countriesapp.feature_country.domain.repository.CountryRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(): List<CountryModel> {
        val response = repository.getAllCountries()

        return response.ifEmpty {
            emptyList()
        }
    }
}