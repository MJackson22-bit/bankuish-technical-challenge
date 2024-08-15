package com.example.bankuish_technical_challenge.domain.entity.githubRepo

import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoLicenseDTO

data class GithubRepoLicenseEntity(
    val key: String,
    val name: String,
    val spdxId: String,
    val url: String,
    val nodeId: String
) {
    constructor(githubRepoLicenseDTO: GithubRepoLicenseDTO?) : this(
        key = githubRepoLicenseDTO?.key.orEmpty(),
        name = githubRepoLicenseDTO?.name ?: "Without license",
        spdxId = githubRepoLicenseDTO?.spdxId.orEmpty(),
        url = githubRepoLicenseDTO?.url.orEmpty(),
        nodeId = githubRepoLicenseDTO?.nodeId.orEmpty()
    )
}