package com.example.countriesapp.feature_country.domain.model

data class Country(
    val independent: Boolean,
    val region: String,
    val subregion: String,
    val name: Name,
    val capital: List<String>,
    val demonyms: Demonyms,
    val maps: Maps,
    val continents: List<String>,
    val flags: Flags,
)