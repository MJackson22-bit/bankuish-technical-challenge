package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.view.GithubRepoDetailsView
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.viewmodel.GithubRepoDetailsViewModel
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.view.GithubReposView
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel.GithubReposViewModel
import com.example.bankuish_technical_challenge.ui.navigation.AppTransition
import org.koin.androidx.compose.koinViewModel


fun NavGraphBuilder.githubRepoDetails(navController: NavHostController) {
    composable(AppTransition.GithubRepoDetailsScreen.route) {
        val viewModel: GithubRepoDetailsViewModel = koinViewModel()
        val ownerId = it.arguments?.getString("owner_id").orEmpty()
        val repoId = it.arguments?.getString("repo_id").orEmpty()
        viewModel.state = viewModel.state.copy(
            ownerId = ownerId,
            repoId = repoId
        )
        GithubRepoDetailsView(
            state = viewModel.state,
            onEvent = viewModel::onEvent
        ) {
            navController.popBackStack()
        }
    }
}