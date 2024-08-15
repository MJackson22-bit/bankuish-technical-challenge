package com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class GithubReposViewModel(
    private val githubRepoRepository: IGithubRepoRepository
) : ViewModel() {

    var state by mutableStateOf(GithubReposState())
    private val scope = CoroutineScope(Dispatchers.IO)

    fun onEvent(event: GithubReposEvent) {
        when (event) {
            is GithubReposEvent.FetchGithubRepos -> getGithubRepos(event.query)
            is GithubReposEvent.DidPullToRefresh -> {
                state = state.copy(
                    currentPage = 1,
                    isRefreshing = true
                )
                getGithubRepos(event.query)
            }

            is GithubReposEvent.DidTapRepo -> {
                // Go to detail screen
                Log.i("GithubReposViewModel", "DidTapRepo: ${event.githubRepoItemEntity}")
            }
        }
    }

    private fun getGithubRepos(query: String) {
        state = if (state.currentPage == 1 && state.repos.isEmpty()) {
            state.copy(
                showShimmer = true
            )
        } else {
            state.copy(
                isLoading = true
            )
        }

        scope.launch {
            state = when (val result =
                githubRepoRepository.getGithubRepos(query, 20, state.currentPage)) {
                is ApiResponse.Error -> {
                    state.copy(
                        isLoading = false,
                        error = result.message,
                        showShimmer = false,
                        isRefreshing = false
                    )
                }

                is ApiResponse.Success -> {
                    val repos =
                        if (state.isRefreshing) result.data.items else state.repos + result.data.items
                    state.copy(
                        showShimmer = false,
                        isLoading = false,
                        isRefreshing = false,
                        repos = repos,
                        currentPage = state.currentPage + 1
                    )
                }
            }
        }
    }
}