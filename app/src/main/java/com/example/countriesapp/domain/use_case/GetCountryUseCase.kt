package com.example.countriesapp.domain.use_case

import com.example.countriesapp.data.model.DetailCountry
import com.example.countriesapp.data.CountryRepository
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