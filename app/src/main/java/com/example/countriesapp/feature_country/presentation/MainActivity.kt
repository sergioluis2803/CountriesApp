package com.example.countriesapp.feature_country.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countriesapp.feature_country.presentation.countries.CountriesScreen
import com.example.countriesapp.feature_country.presentation.detail_country.DetailCountryScreen
import com.example.countriesapp.feature_country.presentation.util.Screen
import com.example.countriesapp.ui.theme.CountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CountriesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CountriesScreen.route
                    ) {
                        composable(route = Screen.CountriesScreen.route) {
                            CountriesScreen(navController = navController)
                        }

                        composable(
                            route = Screen.DetailCountryScreen.route + "/{nameCountry}",
                            arguments = listOf(navArgument("nameCountry") {
                                type = NavType.StringType
                            })
                        ) {
                            val nameCountry = it.arguments?.getString("nameCountry")
                            requireNotNull(nameCountry) { "No puede ser nulo" }
                            DetailCountryScreen(navController = navController, nameCountry)
                        }
                    }

                }
            }
        }
    }

}
