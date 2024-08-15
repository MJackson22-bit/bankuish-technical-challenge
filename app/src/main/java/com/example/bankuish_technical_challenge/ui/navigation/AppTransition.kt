package com.example.bankuish_technical_challenge.ui.navigation

sealed class AppTransition(val route: String) {
    data object GithubReposScreen : AppTransition("github_repos_screen")
    data object GithubRepoDetailsScreen : AppTransition("github_repo_details_screen/{owner_id}/{repo_id}") {
        fun passId(ownerId: String, repoId: String): String {
            return route.replace(oldValue = "{repo_id}", newValue = repoId)
                .replace(oldValue = "{owner_id}", newValue = ownerId)
        }
    }
}