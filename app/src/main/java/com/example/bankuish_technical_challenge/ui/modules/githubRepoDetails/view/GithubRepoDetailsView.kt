package com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bankuish_technical_challenge.R
import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoItemDTO
import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoLicenseDTO
import com.example.bankuish_technical_challenge.data.response.githubRepo.GithubRepoOwnerDTO
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity
import com.example.bankuish_technical_challenge.ui.components.BTCRefreshableList
import com.example.bankuish_technical_challenge.ui.components.BTCShimmeryView
import com.example.bankuish_technical_challenge.ui.components.loading.GithubReposShimmer
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsEvent
import com.example.bankuish_technical_challenge.ui.modules.githubRepoDetails.GithubRepoDetailsState
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkTextColor
import com.example.bankuish_technical_challenge.ui.theme.BtcGrayBackground
import com.example.bankuish_technical_challenge.utils.helpers.btcLightText
import com.example.bankuish_technical_challenge.utils.helpers.btcText
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GithubRepoDetailsView(
    state: GithubRepoDetailsState,
    onEvent: (GithubRepoDetailsEvent) -> Unit,
    onBack: () -> Unit
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        scope.launch {
            onEvent(GithubRepoDetailsEvent.FetchGithubRepoDetails)
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onBack()
                            },
                        painter = painterResource(id = R.drawable.ic_arrow_left),
                        tint = BtcDarkTextColor,
                        contentDescription = null
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    Spacer(modifier = Modifier.height(60.dp))

                    AsyncImage(
                        model = state.repo.owner.avatarUrl,
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_person),
                        error = painterResource(id = R.drawable.ic_person),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = state.repo.fullName,
                        style = TextStyle.btcText(16.sp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = state.repo.description,
                        style = TextStyle.btcText(16.sp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star_half),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "${state.repo.stargazersCount} stars",
                                style = TextStyle.btcLightText(16.sp)
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_code_fork),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(2.dp)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "${state.repo.stargazersCount} forks",
                                style = TextStyle.btcLightText(16.sp)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bug_report),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Issues",
                                style = TextStyle.btcText(14.sp)
                            )
                        }
                        Text(
                            text = state.repo.openIssuesCount.toString(),
                            style = TextStyle.btcLightText(16.sp)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_eye),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Watchers",
                                style = TextStyle.btcText(14.sp)
                            )
                        }

                        Text(
                            text = state.repo.watchers.toString(),
                            style = TextStyle.btcLightText(16.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_license),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "License",
                                style = TextStyle.btcText(14.sp)
                            )
                        }

                        Text(
                            text = state.repo.licence.name,
                            style = TextStyle.btcLightText(16.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_git_branch),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "Default branch",
                                style = TextStyle.btcText(14.sp)
                            )
                        }

                        Text(
                            text = state.repo.defaultBranch,
                            style = TextStyle.btcLightText(16.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_code),
                                contentDescription = null,
                                tint = BtcDarkTextColor,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = "Language",
                                style = TextStyle.btcText(14.sp)
                            )
                        }

                        Text(
                            text = state.repo.language,
                            style = TextStyle.btcLightText(16.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }

            }
        }
    }
}

@Composable
@Preview
fun GithubRepoDetailsViewPreview() {
    GithubRepoDetailsView(
        state = GithubRepoDetailsState(
            repo = GithubRepoItemEntity(
                GithubRepoItemDTO(
                    id = 1,
                    name = "kotlin",
                    fullName = "kotlin/kotlin",
                    description = "kotlin description",
                    stargazersCount = 10,
                    openIssuesCount = 23,
                    defaultBranch = "master",
                    language = "Kotlin",
                    watchers = 45,
                    license = GithubRepoLicenseDTO(
                        name = "MIT"
                    ),
                    owner = GithubRepoOwnerDTO(
                        id = 1,
                        login = "kotlin",
                        avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
                        type = "User"
                    )
                )
            )
        ),
        onEvent = {},
        onBack = {}
    )
}