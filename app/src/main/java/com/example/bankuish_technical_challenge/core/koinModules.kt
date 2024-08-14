package com.example.bankuish_technical_challenge.core

import com.example.bankuish_technical_challenge.core.di.apiServiceModule
import com.example.bankuish_technical_challenge.core.di.networkModule
import com.example.bankuish_technical_challenge.core.di.repositoryModule
import com.example.bankuish_technical_challenge.core.di.viewModelModule

val koinModules = listOf(
    networkModule,
    apiServiceModule,
    viewModelModule,
    repositoryModule
)