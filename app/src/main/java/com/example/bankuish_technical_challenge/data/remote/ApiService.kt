package com.example.bankuish_technical_challenge.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get


class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun getGithubRepos(
        query: String,
        perPage: Int,
        page: Int
    ) = httpClient.get("search/repositories?q=$query&per_page=$perPage&page=$page")
}