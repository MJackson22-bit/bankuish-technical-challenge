package com.example.bankuish_technical_challenge.ui.navigation

sealed class AppTransition(val route: String) {
    data object GithubReposScreen : AppTransition("github_repos_screen")
    data object GithubRepoDetailsScreen : AppTransition("github_repo_details_screen/{repo_id}") {
        fun passId(id: Int): String {
            return route.replace(oldValue = "{repo_id}", newValue = id.toString())
        }
    }
}