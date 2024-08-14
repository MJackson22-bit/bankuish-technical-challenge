package com.example.bankuish_technical_challenge.domain.entity.githubRepo

import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoResponseDTO

data class GithubRepoEntity(
    val totalCount: Int,
    val items: List<GithubRepoItemEntity>,
    val incompleteResults: Boolean
) {
    constructor(githubRepoResponseDTO: GithubRepoResponseDTO?) : this(
        totalCount = githubRepoResponseDTO?.totalCount ?: 0,
        items = githubRepoResponseDTO?.items?.map { GithubRepoItemEntity(it) }.orEmpty(),
        incompleteResults = githubRepoResponseDTO?.incompleteResults ?: false
    )
}
