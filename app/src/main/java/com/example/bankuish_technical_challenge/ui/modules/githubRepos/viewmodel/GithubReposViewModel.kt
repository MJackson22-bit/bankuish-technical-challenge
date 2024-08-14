package com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bankuish_technical_challenge.data.ApiResponse
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.GithubReposState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubReposViewModel(
    private val githubRepoRepository: IGithubRepoRepository
) : ViewModel() {

    var state by mutableStateOf(GithubReposState())
    private val scope = CoroutineScope(Dispatchers.IO)

    fun getGithubRepos(query: String) {
        state = state.copy(
            isLoading = true
        )

        scope.launch {
            state = when(val result = githubRepoRepository.getGithubRepos(query, 20, 1)) {
                is ApiResponse.Error -> {
                    state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }

                is ApiResponse.Success -> {
                    state.copy(
                        isLoading = false,
                        repos = result.data.items
                    )
                }
            }
        }
    }
}