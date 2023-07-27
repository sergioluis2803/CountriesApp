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
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.countriesapp.feature_country.presentation.countries.components.CountryItem
import com.example.countriesapp.feature_country.presentation.detail_country.DetailScreenViewModel
import com.example.countriesapp.feature_country.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CountriesScreen(
    viewModel: CountriesViewModel,
    navController: NavHostController,
    detailCountryViewModel: DetailScreenViewModel
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            TextField(
                value = viewModel.searchQuery.value,
                onValueChange = { query -> viewModel.setSearchQuery(query) },
                maxLines = 1,
                singleLine = true,
                placeholder = { Text(text = "Find a country") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Blue,
                ),
                shape = TextFieldDefaults.outlinedShape,
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
            )

            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModel.filterCountry) { country ->
                    CountryItem(
                        item = country,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .clickable {
                                navController.navigate(Screen.DetailCountryScreen.route + "/${country.name.common}")
                                detailCountryViewModel.getDetailCountry(country.name.common.lowercase())
                            }
                    )
                }
            }
        }
    }
}