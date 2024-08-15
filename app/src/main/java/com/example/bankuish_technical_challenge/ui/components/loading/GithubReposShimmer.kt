package com.example.bankuish_technical_challenge.ui.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankuish_technical_challenge.ui.components.ComposableShimmer
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkBackground
import com.example.bankuish_technical_challenge.utils.helpers.shimmerEffect

val GithubReposShimmer = ComposableShimmer {

    LazyColumn {
        items(10) {
            Box(contentAlignment = Alignment.CenterEnd) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BtcDarkBackground)
                        .padding(top = 20.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(90.dp))
                                .shimmerEffect()
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        Column(
                            verticalArrangement = Arrangement.spacedBy(15.dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(width = 80.dp, height = 15.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .shimmerEffect()
                            )

                            Box(
                                modifier = Modifier
                                    .size(width = 80.dp, height = 15.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .shimmerEffect()
                            )
                        }

                        Spacer(modifier = Modifier.width(30.dp))

                        Column(
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 15.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .shimmerEffect()
                            )

                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 15.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .shimmerEffect()
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardListShimmerPreview() {
    GithubReposShimmer.view()
}