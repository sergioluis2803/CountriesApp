package com.example.countriesapp.feature_country.presentation.detail_country

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.countriesapp.feature_country.presentation.countries.components.FlagCountry
import com.example.countriesapp.feature_country.presentation.detail_country.components.DetailCountry
import com.example.countriesapp.feature_country.presentation.util.Screen

@Composable
fun DetailCountryScreen(
    navController: NavHostController,
    detailCountryViewModel: DetailScreenViewModel
) {

    val item = detailCountryViewModel.detailCountry

    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.navigate(Screen.CountriesScreen.route) },
            modifier = Modifier.width(100.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "back_screen_main",
                    modifier = Modifier.rotate(180f)
                )
                Text(text = "Back")
            }
        }

        FlagCountry(
            item = item, Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            DetailCountry(
                item,
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
        }

    }
}