package com.example.bankuish_technical_challenge.domain.entity.githubRepo

import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoOwnerDTO

data class GithubRepoOwnerEntity(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val type: String
) {
    constructor(githubRepoOwnerDTO: GithubRepoOwnerDTO?) : this(
        id = githubRepoOwnerDTO?.id ?: 0,
        login = githubRepoOwnerDTO?.login.orEmpty(),
        avatarUrl = githubRepoOwnerDTO?.avatarUrl.orEmpty(),
        type = githubRepoOwnerDTO?.type.orEmpty()
    )
}