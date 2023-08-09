package com.example.countriesapp.data.model

data class CountryModel(
    val independent: Boolean,
    val region: String,
    val subregion: String,
    val name: Name,
    val capital: List<String>,
    val demonyms: Demonyms,
    val continents: List<String>,
    val flags: Flags,
)