package com.example.bankuish_technical_challenge.data.response.githubRepo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoOwnerDTO(
    @SerialName("id") val id: Int?,
    @SerialName("login") val login: String?,
    @SerialName("avatar_url") val avatarUrl: String?
)
