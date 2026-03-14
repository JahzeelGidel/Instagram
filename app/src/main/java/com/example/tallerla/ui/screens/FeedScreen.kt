package com.example.tallerla.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tallerla.data.DataSource
import com.example.tallerla.ui.components.PostCard
import com.example.tallerla.ui.components.StoriesRow
import androidx.compose.ui.tooling.preview.Preview
import com.example.tallerla.ui.theme.InstagramCloneTheme

@Composable
fun FeedScreen() {
    val posts = remember { DataSource.getPosts() }
    val stories = remember { DataSource.getStories() }

    Scaffold(
        topBar = { InstagramTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = rememberLazyListState()
        ) {
            item(key = "stories_row") {
                StoriesRow(stories = stories)
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
            items(posts, key = { post -> post.id }) { post ->
                PostCard(post = post, onLikeClick = { likedPost ->
                    println("Like en ${likedPost.username}")
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Notificaciones")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Send, contentDescription = "Mensajes")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}


@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    InstagramCloneTheme {
        FeedScreen()
    }
}