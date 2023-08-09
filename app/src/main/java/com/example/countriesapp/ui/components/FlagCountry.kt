package com.example.countriesapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.example.countriesapp.data.model.CountryModel

@Composable
fun FlagCountry(item: CountryModel, modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        Image(
            painter = rememberAsyncImagePainter(model = item.flags.png),
            contentDescription = "flag_country",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }

}
