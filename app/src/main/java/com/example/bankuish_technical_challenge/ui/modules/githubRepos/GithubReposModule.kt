package com.example.bankuish_technical_challenge.ui.modules.githubRepos

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.view.GithubReposView
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel.GithubReposViewModel
import com.example.bankuish_technical_challenge.ui.navigation.AppTransition
import org.koin.androidx.compose.koinViewModel


fun NavGraphBuilder.githubRepos(navController: NavHostController) {
    composable(AppTransition.GithubReposScreen.route) {
        val viewModel: GithubReposViewModel = koinViewModel()
        GithubReposView(
            state = viewModel.state,
            onEvent = viewModel::onEvent
        ) { owner, repo ->
            navController.navigate(AppTransition.GithubRepoDetailsScreen.passId(
                ownerId = owner,
                repoId = repo
            ))
        }
    }
}