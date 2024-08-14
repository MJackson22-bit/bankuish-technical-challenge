package com.example.bankuish_technical_challenge.ui.modules.githubRepos.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankuish_technical_challenge.ui.modules.githubRepos.viewmodel.GithubReposViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun GithubReposView(
    viewModel: GithubReposViewModel = koinViewModel(),
    onClickRepo: (Int) -> Unit
) {

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            viewModel.getGithubRepos("kotlin")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = viewModel.state.repos.toString())
    }
}

@Composable
@Preview
fun GithubReposViewPreview() {
    GithubReposView { }
}