package com.example.countriesapp.feature_country.presentation.countries.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countriesapp.feature_country.domain.model.Country

@Composable
fun InfoCountry(item: Country) {
    Column(
        modifier = Modifier
            .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
    ) {

        Text(
            text = item.name.common,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Region: "+item.region,
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = "Capital: "+item.capital.toString(),
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp
        )
    }

}

