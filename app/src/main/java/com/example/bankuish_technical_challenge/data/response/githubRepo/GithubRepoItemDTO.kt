package com.example.bankuish_technical_challenge.data.response.githubRepo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoItemDTO(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("full_name") val fullName: String? = null,
    @SerialName("private") val private: Boolean? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("fork") val fork: Boolean? = null,
    @SerialName("forks_count") val forksCount: Int? = null,
    @SerialName("open_issues_count") val openIssuesCount: Int? = null,
    @SerialName("watchers") val watchers: Int? = null,
    @SerialName("default_branch") val defaultBranch: String? = null,
    @SerialName("language") val language: String? = null,
    @SerialName("stargazers_count") val stargazersCount: Int? = null,
    @SerialName("has_issues") val hasIssues: Boolean? = null,
    @SerialName("has_wiki") val hasWiki: Boolean? = null,
    @SerialName("topics") val topics: List<String>? = null,
    @SerialName("license") val license: GithubRepoLicenseDTO? = null,
    @SerialName("owner") val owner: GithubRepoOwnerDTO? = null
)
