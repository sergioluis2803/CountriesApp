package com.example.countriesapp.ui.countries

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.countriesapp.R
import com.example.countriesapp.data.model.CountryModel
import com.example.countriesapp.ui.countries.components.CountryItem
import com.example.countriesapp.ui.components.CustomStyleCircularProgress
import com.example.countriesapp.ui.countries.util.HomeUiState
import com.example.countriesapp.ui.util.ColorCardCountry
import com.example.countriesapp.ui.util.Screen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CountriesScreen(
    navController: NavHostController,
    homeViewModel: CountriesViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 8.dp)
    ) {

        TextField(
            value = uiState.searchInput,
            onValueChange = { query -> homeViewModel.setSearchQuery(query) },
            singleLine = true,
            placeholder = { Text(text = "Find a country") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black),
            shape = TextFieldDefaults.outlinedShape,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                }
            )
        )

        Spacer(modifier = Modifier.padding(bottom = 10.dp))

        if (uiState.isLoading) {
            CustomStyleCircularProgress(Modifier.fillMaxSize())
        } else {

            when (uiState) {
                is HomeUiState.NoCountries -> {

                }

                is HomeUiState.HasCountries -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items((uiState as HomeUiState.HasCountries).filterCountry) { country ->
                            CountryItem(
                                item = country,
                                colorCard = backgroundCardCountry(country),
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