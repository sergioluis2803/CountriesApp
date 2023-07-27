package com.example.countriesapp.feature_country.presentation.countries.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.countriesapp.R
import com.example.countriesapp.feature_country.domain.model.Country

@Composable
fun CountryItem(
    item: Country,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(colorResource(id = R.color.country_item))
                    .padding(6.dp)
            ) {
                FlagCountry(
                    item = item,
                    modifier = Modifier
                        .width(150.dp)
                        .height(450.dp)
                )
                InfoCountry(item)
            }
        }
    }
}