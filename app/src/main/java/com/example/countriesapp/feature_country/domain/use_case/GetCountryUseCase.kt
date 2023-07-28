package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.feature_country.domain.model.DetailCountry
import com.example.countriesapp.feature_country.domain.repository.CountryApi
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryApi
) {
    suspend operator fun invoke(nameCountry: String): DetailCountry {
        return repository.getCountryDescription(nameCountry)
    }
}