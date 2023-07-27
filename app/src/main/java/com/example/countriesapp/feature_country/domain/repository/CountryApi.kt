package com.example.countriesapp.feature_country.domain.repository

import com.example.countriesapp.feature_country.domain.model.Country
import com.example.countriesapp.feature_country.domain.model.DetailCountry
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {

    @GET("all")
    suspend fun getAllCountries(): List<Country>

    @GET("name/{detail}")
    suspend fun getCountryDescription(
        @Path("detail") detail: String
    ): DetailCountry
}