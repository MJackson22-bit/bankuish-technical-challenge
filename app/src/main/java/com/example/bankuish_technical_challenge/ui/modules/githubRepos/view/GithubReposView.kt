package com.example.bankuish_technical_challenge.ui.modules.githubRepos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankuish_technical_challenge.core.di.viewModelModule
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity
import com.example.bankuish_technical_challenge.ui.components.BTCRefreshableList
import com.example.bankuish_technical_challenge.ui.components.BTCScrollableView
import com.example.bankuish_technical_challenge.ui.components.BTCShimmeryView
import com.example.bankuish_technical_challenge.ui.components.loading.GithubReposShimmer
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposState
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel.GithubReposViewModel
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground
import com.example.bankuish_technical_challenge.ui.theme.BtcShadowColor
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GithubReposView(
    state: GithubReposState,
    onEvent: (GithubReposEvent) -> Unit
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
                onEvent(GithubReposEvent.FetchGithubRepos("kotlin"))
            }) {

            BTCShimmeryView(
                key = state.isLoading,
                shimmer = GithubReposShimmer
            ) {

                BTCScrollableView {
                    Spacer(modifier = Modifier.height(16.dp))
                    state.repos.forEach {
                        GithubRepoCellView(item = it)
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
        )
    ) { }
}