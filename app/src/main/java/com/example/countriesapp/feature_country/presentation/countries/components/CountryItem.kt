package com.example.countriesapp.feature_country.presentation.countries.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.countriesapp.R
import com.example.countriesapp.feature_country.domain.model.CountryModel

@Composable
fun CountryItem(
    item: CountryModel,
    colorCard: Int,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = colorCard),
                contentColor = colorResource(id = R.color.black)
            ),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 6.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FlagCountry(
                    item = item,
                    modifier = Modifier
                        .width(140.dp)
                        .height(100.dp)
                )
                InfoCountry(
                    item,
                    Modifier.padding(start = 15.dp)
                )
            }
        }
    }
}