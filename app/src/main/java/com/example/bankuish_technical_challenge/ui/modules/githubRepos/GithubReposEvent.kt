package com.example.bankuish_technical_challenge.ui.modules.githubRepos

import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity

sealed class GithubReposEvent {
    data class FetchGithubRepos(val query: String) : GithubReposEvent()
    data class DidPullToRefresh(val query: String) : GithubReposEvent()
    data class DidTapRepo(val githubRepoItemEntity: GithubRepoItemEntity) : GithubReposEvent()
}