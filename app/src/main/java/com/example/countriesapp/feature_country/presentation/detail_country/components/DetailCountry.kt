package com.example.countriesapp.feature_country.presentation.detail_country.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countriesapp.feature_country.domain.model.Country
import com.example.countriesapp.feature_country.presentation.countries.components.FlagCountry
import java.util.Locale

@Composable
fun DetailCountry(item: Country, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(
            text = item.name.common.uppercase(Locale.ROOT),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.padding(bottom = 6.dp))

        FlagCountry(
            item = item, Modifier
                .fillMaxWidth()
                .height(170.dp)
                .padding(top = 8.dp, end = 15.dp, start = 15.dp, bottom = 2.dp)
        )

        Text(
            text = "Real name: " + item.name.official,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(start = 15.dp),
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))

        Text(
            text = "Capital: " + item.capital.joinToString(),
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Demonyms: " + "M-"+item.demonyms.eng.m + " F-"+item.demonyms.eng.f,
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Independent: " + item.independent,
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Continent: " + item.continents.joinToString(),
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Region: " + item.region,
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Sub-region: " + item.subregion,
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

    }
}