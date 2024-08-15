package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankuish_technical_challenge.ui.components.BTCRefreshableList
import com.example.bankuish_technical_challenge.ui.components.BTCShimmeryView
import com.example.bankuish_technical_challenge.ui.components.loading.GithubReposShimmer
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsState
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GithubRepoDetailsView(
    state: GithubRepoDetailsState,
    onEvent: (GithubRepoDetailsEvent) -> Unit
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            onEvent(GithubRepoDetailsEvent.FetchGithubRepoDetails(state.ownerId, state.repoId))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BtcGrayBackground)
    ) {
        BTCRefreshableList(
            isRefreshing = state.isRefreshing, onRefresh = {
                //onEvent(GithubReposEvent.DidPullToRefresh("kotlin"))
            }) {

            BTCShimmeryView(
                key = state.showShimmer,
                shimmer = GithubReposShimmer
            ) {

                Text(text = "${state.repoId} === ${state.ownerId}")

            }
        }
    }
}

@Composable
@Preview
fun GithubRepoDetailsViewPreview() {
    GithubRepoDetailsView(
        state = GithubRepoDetailsState()
    ) { }
}