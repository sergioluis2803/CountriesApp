package com.example.countriesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.countriesapp.ui.countries.CountriesScreen
import com.example.countriesapp.ui.detail_country.DetailCountryScreen
import com.example.countriesapp.ui.util.Screen

@Composable
fun NavigationAppCountry() {
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