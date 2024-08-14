package com.example.bankuish_technical_challenge.core.di

import com.example.bankuish_technical_challenge.data.repository.GithubRepoRepositoryImpl
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IGithubRepoRepository> { GithubRepoRepositoryImpl(get()) }
}