package com.example.countriesapp.feature_country.presentation.detail_country.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.countriesapp.feature_country.presentation.util.Screen

@Composable
fun ButtonBack(navController: NavHostController) {
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
}