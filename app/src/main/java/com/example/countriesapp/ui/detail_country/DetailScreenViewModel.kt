package com.example.countriesapp.ui.detail_country

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.data.model.Demonyms
import com.example.countriesapp.data.model.Eng
import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.data.model.Flags
import com.example.countriesapp.data.model.Name
import com.example.countriesapp.domain.use_case.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val detailCountryUseCase : GetCountryUseCase
) : ViewModel() {

    private val _detailCountry = mutableStateOf(
        CountryModel(
            independent = false,
            region = "",
            subregion = "",
            name = Name("", ""),
            capital = listOf(""),
            demonyms = Demonyms(Eng("", "")),
            continents = listOf(""),
            flags = Flags(""),
        )
    )
    val detailCountry: CountryModel get() = _detailCountry.value

    @SuppressLint("SuspiciousIndentation")
    fun getDetailCountry(nameCountry: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = detailCountryUseCase.invoke(nameCountry.lowercase())
                _detailCountry.value = detailCountry.copy(
                    independent = result[0].independent,
                    region = result[0].region,
                    subregion = result[0].subregion,
                    name = Name(result[0].name.common, result[0].name.official),
                    capital = result[0].capital,
                    demonyms = Demonyms(Eng(result[0].demonyms.eng.f, result[0].demonyms.eng.m)),
                    continents = result[0].continents,
                    flags = Flags(result[0].flags.png),
                )
            } catch (error: Exception) {
                Log.d("ERROR", "error in detail: ${error.message}")
            }
        }
    }
}