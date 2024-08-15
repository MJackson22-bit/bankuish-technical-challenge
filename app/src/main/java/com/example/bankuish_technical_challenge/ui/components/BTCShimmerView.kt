package com.example.bankuish_technical_challenge.ui.components

import androidx.compose.runtime.Composable


class ComposableShimmer(
    var view: @Composable () -> Unit
)

@Composable
fun BTCShimmeryView(
    key: Boolean,
    shimmer: ComposableShimmer,
    content: @Composable () -> Unit
) = if (key) shimmer.view() else content()