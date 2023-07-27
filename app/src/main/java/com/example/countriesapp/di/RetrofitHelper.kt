package com.example.countriesapp.di

import com.example.countriesapp.feature_country.domain.repository.CountryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL = "https://restcountries.com/v3.1/"

    val instance: CountryApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CountryApi::class.java)
    }
}