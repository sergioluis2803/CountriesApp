package com.example.countriesapp.feature_country.presentation.countries.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.countriesapp.feature_country.domain.model.Country

@OptIn(ExperimentalCoilApi::class)
@Composable
fun FlagCountry(item: Country, modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Image(
            painter = rememberImagePainter(data = item.flags.png),
            contentDescription = "flag_country",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }

}
