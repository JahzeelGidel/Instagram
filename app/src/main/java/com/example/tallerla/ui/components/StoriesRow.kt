package com.example.tallerla.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tallerla.model.Story
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StoriesRow(stories: List<Story>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(stories, key = { story -> story.id }) { story ->
            StoryItem(story = story)
        }
    }
}

@Composable
fun StoryItem(story: Story) {
    val borderBrush = if (!story.hasSeen) {
        Brush.linearGradient(
            colors = listOf(Color(0xFFf09433), Color(0xFFdc2743), Color(0xFFbc1888))
        )
    } else {
        SolidColor(Color.LightGray)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(70.dp)) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(2.dp, borderBrush, CircleShape)
                .padding(3.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = story.profileImageUrl,
                contentDescription = story.username,
                modifier = Modifier.size(56.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(text = story.username, fontSize = 11.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

@Preview(showBackground = true)
@Composable
fun StoriesRowPreview() {
    val sampleStories = listOf(
        Story(1, "tu_historia", "https://example.com/p1.jpg", false),
        Story(2, "usuario1", "https://example.com/p2.jpg", false),
        Story(3, "usuario2", "https://example.com/p3.jpg", true),
        Story(4, "usuario3", "https://example.com/p4.jpg", false)
    )
    StoriesRow(stories = sampleStories)
}