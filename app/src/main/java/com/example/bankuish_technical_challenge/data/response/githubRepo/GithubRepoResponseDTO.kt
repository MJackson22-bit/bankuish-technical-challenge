package com.example.bankuish_technical_challenge.data.response.githubRepo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepoResponseDTO(
    @SerialName("total_count") val totalCount: Int?,
    @SerialName("items") val items: List<GithubRepoItemDTO>?,
    @SerialName("incomplete_results") val incompleteResults: Boolean?
)
