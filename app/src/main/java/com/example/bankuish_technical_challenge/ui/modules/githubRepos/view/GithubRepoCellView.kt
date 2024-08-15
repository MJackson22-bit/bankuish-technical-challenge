package com.example.bankuish_technical_challenge.ui.modules.githubRepos.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoItemEntity
import com.example.bankuish_technical_challenge.domain.entity.githubRepo.GithubRepoOwnerEntity
import com.example.bankuish_technical_challenge.ui.theme.BtcDarkBackground
import com.example.bankuish_technical_challenge.utils.helpers.mtcLightText
import com.example.bankuish_technical_challenge.utils.helpers.mtcText
import com.example.bankuish_technical_challenge.utils.helpers.shadow

@Composable
fun GithubRepoCellView(
    item: GithubRepoItemEntity
) {
    Box(
        contentAlignment = Alignment.CenterEnd
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 6.dp)
                .shadow(0f, offsetY = 2.dp),
            colors = CardDefaults.cardColors(containerColor = BtcDarkBackground),
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .background(BtcDarkBackground)
                    .padding(top = 20.dp, bottom = 20.dp),
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){

                    AsyncImage(
                        model = item.owner.avatarUrl,
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_person),
                        error = painterResource(id = R.drawable.ic_person),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(58.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row {

                            Text(
                                text = "Name",
                                style = TextStyle.mtcText(14.sp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = item.name,
                                style = TextStyle.mtcLightText()
                            )
                        }

                        Row {
                            Text(
                                text = "Author",
                                style = TextStyle.mtcText(14.sp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = item.owner.login,
                                style = TextStyle.mtcLightText()
                            )
                        }
                    }



                }
            }

        }
    }
}

@Preview
@Composable
fun GithubRepoCellViewPreview() {
    GithubRepoCellView(GithubRepoItemEntity(
        id = 1,
        name = "name",
        fullName = "fullName",
        owner = GithubRepoOwnerEntity(
            login = "login",
            id = 1,
            avatarUrl = "avatarUrl"
        )
    ))
}