package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails

import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposEvent

sealed class GithubRepoDetailsEvent {
    data object FetchGithubRepoDetails : GithubRepoDetailsEvent()
}