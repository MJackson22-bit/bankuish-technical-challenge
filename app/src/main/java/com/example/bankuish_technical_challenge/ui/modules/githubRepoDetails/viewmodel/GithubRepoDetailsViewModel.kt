package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bankuish_technical_challenge.domain.repository.IGithubRepoRepository
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class GithubRepoDetailsViewModel(
    private val githubRepoRepository: IGithubRepoRepository
) : ViewModel() {
    var state by mutableStateOf(GithubRepoDetailsState())
    private val scope = CoroutineScope(Dispatchers.IO)

    fun onEvent(event: GithubRepoDetailsEvent) {
        when (event) {
            is GithubRepoDetailsEvent.FetchGithubRepoDetails -> {

            }
        }
    }
}