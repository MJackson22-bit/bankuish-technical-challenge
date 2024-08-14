package com.example.bankuish_technical_challenge.data.repository

import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.data.remote.ApiService
import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoResponseDTO
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoEntity
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import io.ktor.client.call.body

class GithubRepoRepositoryImpl(
    private val apiService: ApiService
) : IGithubRepoRepository {

    override suspend fun getGithubRepos(
        query: String,
        perPage: Int,
        page: Int
    ): ApiResponse<GithubRepoEntity> {

        val response = apiService.getGithubRepos(query, perPage, page)

        return if (response.status.value in 200..299) {
            val data = response.body<GithubRepoResponseDTO?>()
            ApiResponse.Success(GithubRepoEntity(data))
        } else {
            ApiResponse.Error("Internal Server Error")
        }
    }
}