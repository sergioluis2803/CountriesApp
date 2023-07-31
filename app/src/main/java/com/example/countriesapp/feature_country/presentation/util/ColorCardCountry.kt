package com.example.countriesapp.feature_country.presentation.util

import com.example.countriesapp.R

sealed class ColorCardCountry(val colorCard: Int) {
    object Oceania : ColorCardCountry(R.color.oceania)
    object Antarctica : ColorCardCountry(R.color.antarctica)
    object Africa : ColorCardCountry(R.color.africa)
    object Asia : ColorCardCountry(R.color.asia)
    object Europe : ColorCardCountry(R.color.europe)
    object NorthAmerica : ColorCardCountry(R.color.north_america)
    object SouthAmerica : ColorCardCountry(R.color.south_america)
}