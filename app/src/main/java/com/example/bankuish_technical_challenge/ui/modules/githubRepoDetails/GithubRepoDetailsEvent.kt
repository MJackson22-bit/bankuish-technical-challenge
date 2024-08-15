package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails

import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposEvent

sealed class GithubRepoDetailsEvent {
    data class FetchGithubRepoDetails(val ownerId: String, val repoId: String) : GithubRepoDetailsEvent()
}