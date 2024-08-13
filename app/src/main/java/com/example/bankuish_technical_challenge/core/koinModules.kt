package com.example.bankuish_technical_challenge.core

import com.example.bankuish_technical_challenge.core.di.dataModule
import com.example.bankuish_technical_challenge.core.di.mainModule
import com.example.bankuish_technical_challenge.core.di.networkModule
import com.example.bankuish_technical_challenge.core.di.repositoryModule
import com.example.bankuish_technical_challenge.core.di.useCaseModule
import com.example.bankuish_technical_challenge.core.di.viewModelModule

val koinModules = listOf(
    dataModule,
    mainModule,
    networkModule,
    useCaseModule,
    viewModelModule,
    repositoryModule
)