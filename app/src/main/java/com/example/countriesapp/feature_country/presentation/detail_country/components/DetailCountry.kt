package com.example.countriesapp.feature_country.presentation.detail_country.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countriesapp.feature_country.domain.model.Country

@Composable
fun DetailCountry(item: Country, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(text = "Country: " + item.name.common, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(text = "Real name: " + item.name.official, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(text = "Region: " + item.region, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(text = "Sub-region: " + item.subregion, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(text = "Continent: " + item.continents, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(text = "Capital: " + item.capital, fontSize = 16.sp)
    }
}