package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails

import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity

data class GithubRepoDetailsState(
    val repo: GithubRepoItemEntity = GithubRepoItemEntity(null),
    val ownerId: String = "",
    val repoId: String = "",
    val showShimmer: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false
)