package com.example.bankuish_technical_challenge.data.response.githubRepo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoItemDTO(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?,
    @SerialName("full_name") val fullName: String?,
    @SerialName("owner") val owner: GithubRepoOwnerDTO?
)
