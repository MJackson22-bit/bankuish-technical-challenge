package com.example.bankuish_technical_challenge.core.application

import android.app.Application
import com.example.bankuish_technical_challenge.core.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BankuishTechnicalChallengeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BankuishTechnicalChallengeApp)
            modules(koinModules)
        }
    }
}