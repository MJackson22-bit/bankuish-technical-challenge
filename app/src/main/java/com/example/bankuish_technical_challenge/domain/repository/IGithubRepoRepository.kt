package com.example.bankuish_technical_challenge.domain.repository

import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoEntity

interface IGithubRepoRepository {
    suspend fun getGithubRepos(query: String, perPage: Int, page: Int): ApiResponse<GithubRepoEntity>
}