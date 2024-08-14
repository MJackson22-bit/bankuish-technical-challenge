package com.example.bankuish_technical_challenge.core.di

import com.example.bankuish_technical_challenge.data.remote.ApiService
import org.koin.dsl.module

val apiServiceModule = module {
    factory { ApiService(get()) }
}