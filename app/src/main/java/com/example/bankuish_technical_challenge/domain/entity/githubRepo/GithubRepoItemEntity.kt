package com.example.bankuish_technical_challenge.domain.entity.githubRepo

import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoItemDTO

data class GithubRepoItemEntity(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: GithubRepoOwnerEntity
) {
    constructor(githubRepoItemDTO: GithubRepoItemDTO?) : this(
        id = githubRepoItemDTO?.id ?: 0,
        name = githubRepoItemDTO?.name.orEmpty(),
        fullName = githubRepoItemDTO?.fullName.orEmpty(),
        owner = GithubRepoOwnerEntity(githubRepoItemDTO?.owner)
    )
}
