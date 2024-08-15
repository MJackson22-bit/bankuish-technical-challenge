package com.example.bankuish_technical_challenge.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.pullRefreshIndicatorTransform
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Surface
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bankuish_technical_challenge.R
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkBackground
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground

@ExperimentalMaterialApi
@Composable
fun BTCRefreshableList(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit
) {

    val refreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onRefresh
    )

    val rotation = animateFloatAsState(
        targetValue = refreshState.progress * 120,
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshState)
    ) {

        content()

        Surface(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.TopCenter)
                .pullRefreshIndicatorTransform(refreshState, true)
                .rotate(rotation.value),
            shape = RoundedCornerShape(50.dp),
            color = BtcGrayBackground,
            shadowElevation = if (refreshState.progress > 0 || isRefreshing) 20.dp else 0.dp,
        ) {

            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = null,
                tint = BtcDarkBackground
            )
        }
    }
}