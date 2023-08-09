package com.example.countriesapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.countriesapp.ui.navigation.NavigationAppCountry
import com.example.countriesapp.ui.theme.CountriesAppTheme

@Composable
fun CountriesApp() {
    CountriesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavigationAppCountry()
        }
    }
}