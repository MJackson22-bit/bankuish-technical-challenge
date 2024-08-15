package com.example.bankuish_technical_challenge.ui.modules.githubRepos

sealed class GithubReposEvent {
    data class FetchGithubRepos(val query: String) : GithubReposEvent()
}