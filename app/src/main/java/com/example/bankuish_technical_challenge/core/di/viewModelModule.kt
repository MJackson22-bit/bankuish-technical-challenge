package com.example.bankuish_technical_challenge.core.di

import com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel.GithubReposViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GithubReposViewModel(get()) }
}