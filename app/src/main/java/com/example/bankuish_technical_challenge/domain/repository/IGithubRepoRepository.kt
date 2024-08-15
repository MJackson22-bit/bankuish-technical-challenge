package com.example.bankuish_technical_challenge.domain.repository

import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoEntity
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity

interface IGithubRepoRepository {
    suspend fun getGithubRepos(query: String, perPage: Int, page: Int): ApiResponse<GithubRepoEntity>
    suspend fun getGithubRepoDetails(owner: String, repo: String): ApiResponse<GithubRepoItemEntity>
}