package com.example.countriesapp.feature_country.presentation.detail_country

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.countriesapp.R
import com.example.countriesapp.feature_country.presentation.countries.components.ProgressScreen
import com.example.countriesapp.feature_country.presentation.detail_country.components.ButtonBack
import com.example.countriesapp.feature_country.presentation.detail_country.components.DetailCountry
import kotlinx.coroutines.delay

@Composable
fun DetailCountryScreen(
    navController: NavHostController,
    country: String,
    detailCountryViewModel: DetailScreenViewModel = hiltViewModel()
) {
    detailCountryViewModel.getDetailCountry(country.lowercase())

    val item = detailCountryViewModel.detailCountry
    val isLoading by remember { detailCountryViewModel.isLoading }

    LaunchedEffect(key1 = true) {
        detailCountryViewModel.isLoading.value = true
        delay(500)
        detailCountryViewModel.isLoading.value = false

    }

    if (isLoading) {
        ProgressScreen()
    } else {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            ButtonBack(navController = navController)

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.detail_country),
                    contentColor = colorResource(id = R.color.black)
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, colorResource(id = R.color.black))
            ) {
                DetailCountry(
                    item,
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                )
            }

        }
    }

}