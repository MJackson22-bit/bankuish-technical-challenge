package com.example.bankuish_technical_challenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.githubRepos

@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppTransition.GithubReposScreen.route) {
        githubRepos(navController)
    }
}