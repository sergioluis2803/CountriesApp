package com.example.countriesapp.feature_country.presentation.countries.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countriesapp.feature_country.domain.model.CountryModel

@Composable
fun InfoCountry(item: CountryModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {

        Text(
            text = item.name.common,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(bottom = 4.dp))

        Text(
            text = "Continent: " + item.continents.joinToString(),
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp
        )

    }

}

