package com.example.bankuish_technical_challenge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.bankuish_technical_challenge.ui.navigation.AppNavigator

@Composable
fun App() {
    val navController = rememberNavController()
    AppNavigator(navController)
}