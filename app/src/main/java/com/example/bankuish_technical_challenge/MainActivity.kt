package com.example.bankuish_technical_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bankuish_technical_challenge.ui.theme.BankuishtechnicalchallengeTheme
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankuishtechnicalchallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BtcGrayBackground
                ) {
                    App()
                }
            }
        }
    }
}