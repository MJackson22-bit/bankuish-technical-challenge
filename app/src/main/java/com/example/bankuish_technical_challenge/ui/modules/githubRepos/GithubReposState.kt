package com.example.bankuish_technical_challenge.ui.modules.githubRepos

import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity

data class GithubReposState(
    val repos: List<GithubRepoItemEntity> = emptyList(),
    val isLoading: Boolean = false,
    val showShimmer: Boolean = false,
    val error: String? = null,
    val currentPage: Int = 1,
    val isRefreshing: Boolean = false
)
