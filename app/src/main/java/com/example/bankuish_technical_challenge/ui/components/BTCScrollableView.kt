package com.example.bankuish_technical_challenge.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BTCScrollableView(
    content: @Composable (ScrollState) -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)

    ) {

        content(scrollState)
    }
}