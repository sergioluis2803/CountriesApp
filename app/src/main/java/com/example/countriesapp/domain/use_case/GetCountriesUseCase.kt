package com.example.countriesapp.domain.use_case

import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.data.CountryRepository
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