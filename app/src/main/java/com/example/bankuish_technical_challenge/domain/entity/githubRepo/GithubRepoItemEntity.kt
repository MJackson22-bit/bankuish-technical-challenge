package com.example.bankuish_technical_challenge.domain.entity.githubRepo

import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoItemDTO
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

data class GithubRepoItemEntity(
    val id: Int,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val description: String,
    val fork: Boolean,
    val forksCount: Int,
    val openIssuesCount: Int,
    val watchers: Int,
    val defaultBranch: String,
    val stargazersCount: Int,
    val language: String,
    val hasIssues: Boolean,
    val hasWiki: Boolean,
    val topics: List<String>,
    val licence: GithubRepoLicenseEntity,
    val owner: GithubRepoOwnerEntity
) {
    constructor(githubRepoItemDTO: GithubRepoItemDTO?) : this(
        id = githubRepoItemDTO?.id ?: 0,
        name = githubRepoItemDTO?.name.orEmpty(),
        fullName = githubRepoItemDTO?.fullName.orEmpty(),
        private = githubRepoItemDTO?.private ?: false,
        description = githubRepoItemDTO?.description.orEmpty(),
        fork = githubRepoItemDTO?.fork ?: false,
        forksCount = githubRepoItemDTO?.forksCount ?: 0,
        stargazersCount = githubRepoItemDTO?.stargazersCount ?: 0,
        openIssuesCount = githubRepoItemDTO?.openIssuesCount ?: 0,
        watchers = githubRepoItemDTO?.watchers ?: 0,
        defaultBranch = githubRepoItemDTO?.defaultBranch.orEmpty(),
        language = githubRepoItemDTO?.language ?: githubRepoItemDTO?.topics?.firstOrNull().orEmpty(),
        hasIssues = githubRepoItemDTO?.hasIssues ?: false,
        hasWiki = githubRepoItemDTO?.hasWiki ?: false,
        topics = githubRepoItemDTO?.topics ?: emptyList(),
        licence = GithubRepoLicenseEntity(githubRepoItemDTO?.license),
        owner = GithubRepoOwnerEntity(githubRepoItemDTO?.owner)
    )
}
