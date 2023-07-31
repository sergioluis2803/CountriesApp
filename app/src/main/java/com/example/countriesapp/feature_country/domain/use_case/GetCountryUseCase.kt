package com.example.countriesapp.feature_country.domain.use_case

import com.example.countriesapp.feature_country.domain.model.DetailCountry
import com.example.countriesapp.feature_country.domain.repository.CountryRepository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(nameCountry: String): DetailCountry {
        return if (nameCountry.isEmpty()) {
            DetailCountry()
        } else {
            repository.getCountryDescription(nameCountry)
        }
    }
}