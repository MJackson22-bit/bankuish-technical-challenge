package com.example.bankuish_technical_challenge.ui.components.loading


import androidx.compose.foundation.background
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

val GithubRepoDetailsShimmer = ComposableShimmer {

    Box(contentAlignment = Alignment.CenterEnd) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BtcDarkBackground)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(90.dp))
                        .shimmerEffect()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 15.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .shimmerEffect()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .size(width = 200.dp, height = 15.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .shimmerEffect()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )

                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 15.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .shimmerEffect()
                    )
                }

            }
        }
    }
}

@Preview
@Composable
private fun CardListShimmerPreview() {
    GithubRepoDetailsShimmer.view()
}