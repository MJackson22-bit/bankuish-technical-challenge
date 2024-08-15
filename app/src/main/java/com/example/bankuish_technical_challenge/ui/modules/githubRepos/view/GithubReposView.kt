package com.example.bankuish_technical_challenge.ui.modules.githubRepos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity
import com.example.bankuish_technical_challenge.ui.components.BTCRefreshableList
import com.example.bankuish_technical_challenge.ui.components.BTCShimmeryView
import com.example.bankuish_technical_challenge.ui.components.loading.GithubReposShimmer
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposState
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground
import com.example.bankuish_technical_challenge.ui.theme.BtcLightGrayTextColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GithubReposView(
    state: GithubReposState,
    onEvent: (GithubReposEvent) -> Unit,
    onNavigateToDetail: (String, String) -> Unit
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            onEvent(GithubReposEvent.FetchGithubRepos("kotlin"))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BtcGrayBackground)
    ) {
        BTCRefreshableList(
            isRefreshing = state.isRefreshing, onRefresh = {
                onEvent(GithubReposEvent.DidPullToRefresh("kotlin"))
            }) {

            BTCShimmeryView(
                key = state.showShimmer,
                shimmer = GithubReposShimmer
            ) {
                LazyColumn {
                    items(state.repos) {
                        GithubRepoCellView(it, onNavigateToDetail)

                        // Handle pagination
                        if(it == state.repos.last() && !state.isLoading) {
                            onEvent(GithubReposEvent.FetchGithubRepos("kotlin"))
                        }

                        if (it == state.repos.last() && state.isLoading) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {

                                CircularProgressIndicator(color = BtcLightGrayTextColor)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun GithubReposViewPreview() {
    GithubReposView(
        state = GithubReposState(
            repos = listOf(
                GithubRepoItemEntity(null),
                GithubRepoItemEntity(null),
                GithubRepoItemEntity(null)
            )
        ),
        onEvent = {},
        onNavigateToDetail = { _, _ -> }
    )
}