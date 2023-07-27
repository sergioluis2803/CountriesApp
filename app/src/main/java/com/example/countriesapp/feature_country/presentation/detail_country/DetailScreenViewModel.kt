package com.example.countriesapp.feature_country.presentation.detail_country

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.di.RetrofitHelper
import com.example.countriesapp.feature_country.domain.model.Country
import com.example.countriesapp.feature_country.domain.model.Demonyms
import com.example.countriesapp.feature_country.domain.model.Eng
import com.example.countriesapp.feature_country.domain.model.Flags
import com.example.countriesapp.feature_country.domain.model.Maps
import com.example.countriesapp.feature_country.domain.model.Name
import com.example.countriesapp.feature_country.domain.repository.CountryApi
import com.example.countriesapp.feature_country.domain.use_case.GetCountryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailScreenViewModel : ViewModel() {

    private val repository: CountryApi = RetrofitHelper.instance
    private val detailCountryUseCase = GetCountryUseCase(repository)

    private val _detailCountry = mutableStateOf(
        Country(
            independent = false,
            status = "",
            region = "",
            subregion = "",
            name = Name("", ""),
            capital = listOf(""),
            demonyms = Demonyms(Eng("", "")),
            maps = Maps("", ""),
            continents = listOf(""),
            flags = Flags("", ""),
        )
    )
    val detailCountry: Country get() = _detailCountry.value

    @SuppressLint("SuspiciousIndentation")
    fun getDetailCountry(nameCountry: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = detailCountryUseCase.invoke(nameCountry.lowercase())

                _detailCountry.value = detailCountry.copy(
                    independent = result[0].independent,
                    status = result[0].status,
                    region = result[0].region,
                    subregion = result[0].subregion,
                    name = Name(result[0].name.common, result[0].name.official),
                    capital = result[0].capital,
                    demonyms = Demonyms(Eng(result[0].demonyms.eng.f, result[0].demonyms.eng.m)),
                    maps = Maps(result[0].maps.googleMaps, result[0].maps.openStreetMaps),
                    continents = result[0].continents,
                    flags = Flags(result[0].flags.png, result[0].flags.png),
                )
            } catch (error: Exception) {
                Log.d("ERROR", "error in detail: ${error.message}")
            }
        }
    }
}