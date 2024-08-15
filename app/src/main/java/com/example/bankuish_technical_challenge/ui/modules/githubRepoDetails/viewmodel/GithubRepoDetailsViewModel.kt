package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoDetailsViewModel(
    private val githubRepoRepository: IGithubRepoRepository
) : ViewModel() {
    var state by mutableStateOf(GithubRepoDetailsState())
    private val scope = CoroutineScope(Dispatchers.IO)

    fun onEvent(event: GithubRepoDetailsEvent) {
        when (event) {
            is GithubRepoDetailsEvent.FetchGithubRepoDetails -> getGithubRepoDetails()
        }
    }

    private fun getGithubRepoDetails() {
        state = state.copy(
            showShimmer = true
        )

        scope.launch {
            state = when (val result =
                githubRepoRepository.getGithubRepoDetails(state.repoId, state.ownerId)) {
                is ApiResponse.Error -> {
                    state.copy(
                        error = result.message,
                        showShimmer = false,
                        isRefreshing = false
                    )
                }

                is ApiResponse.Success -> {
                    state.copy(
                        showShimmer = false,
                        isRefreshing = false,
                        repo = result.data
                    )
                }
            }
        }
    }
}