package com.example.countriesapp.data.data_source

import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.data.model.DetailCountry
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApiService {

    @GET("all")
    suspend fun getAllCountries(): List<CountryModel>

    @GET("name/{detail}")
    suspend fun getCountryDescription(
        @Path("detail") detail: String
    ): DetailCountry

}