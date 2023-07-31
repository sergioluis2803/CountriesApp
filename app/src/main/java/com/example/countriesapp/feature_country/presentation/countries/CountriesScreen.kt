package com.example.countriesapp.feature_country.presentation.countries

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.countriesapp.R
import com.example.countriesapp.feature_country.domain.model.CountryModel
import com.example.countriesapp.feature_country.presentation.countries.components.CountryItem
import com.example.countriesapp.feature_country.presentation.countries.components.ProgressScreen
import com.example.countriesapp.feature_country.presentation.util.ColorCardCountry
import com.example.countriesapp.feature_country.presentation.util.Screen
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountriesScreen(
    navController: NavHostController,
    countriesViewModel: CountriesViewModel = hiltViewModel()
) {
    val isLoading by remember {countriesViewModel.isLoading}

    LaunchedEffect(key1 = true){
        countriesViewModel.isLoading.value = true
        delay(1500)
        countriesViewModel.isLoading.value = false
    }
    
    if (isLoading) {
        ProgressScreen()
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                TextField(
                    value = countriesViewModel.searchQuery.value,
                    onValueChange = { query -> countriesViewModel.setSearchQuery(query) },
                    maxLines = 1,
                    singleLine = true,
                    placeholder = { Text(text = "Find a country") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
                    shape = TextFieldDefaults.outlinedShape
                )

                Spacer(modifier = Modifier.padding(bottom = 16.dp))

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(countriesViewModel.filterCountry) { country ->
                        val colorCard = backgroundCardCountry(country)
                        CountryItem(
                            item = country,
                            colorCard = colorCard,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                                .clickable {
                                    navController.navigate(Screen.DetailCountryScreen.route + "/${country.name.common}")
                                }
                        )
                    }
                }
            }
        }
    }

}

fun backgroundCardCountry(item: CountryModel): Int {
    var color: Int = R.color.country_item
    when (item.continents[0].lowercase()) {
        "oceania" -> color = ColorCardCountry.Oceania.colorCard
        "antarctica" -> color = ColorCardCountry.Antarctica.colorCard
        "africa" -> color = ColorCardCountry.Africa.colorCard
        "asia" -> color = ColorCardCountry.Asia.colorCard
        "europe" -> color = ColorCardCountry.Europe.colorCard
        "north america" -> color = ColorCardCountry.NorthAmerica.colorCard
        "south america" -> color = ColorCardCountry.SouthAmerica.colorCard
    }
    return color
}