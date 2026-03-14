package com.example.tallerla.data

import com.example.tallerla.model.Post
import com.example.tallerla.model.Story

object DataSource {
    fun getPosts(): List<Post> = listOf(
        Post(1, "android_developer", "https://picsum.photos/seed/user1/200/200",
            "https://picsum.photos/seed/post1/800/800", 1204, "Explorando Jetpack Compose #Android #Kotlin"),
        Post(2, "kotlin_ninja", "https://picsum.photos/seed/user2/200/200",
            "https://picsum.photos/seed/post2/800/800", 847, "Data classes son la mejor feature de Kotlin", true),
        Post(3, "compose_ui", "https://picsum.photos/seed/user3/200/200",
            "https://picsum.photos/seed/post3/800/800", 3456, "Material3 + Compose = perfecta combinación"),

        )

    fun getStories(): List<Story> = listOf(
        Story(1, "Tu historia", "", false),
        Story(2, "android_dev", "https://picsum.photos/seed/s2/200/200"),
        Story(3, "kotlin_fan", "https://picsum.photos/seed/s3/200/200"),
        Story(4, "google_io", "https://picsum.photos/seed/s4/200/200", true),
    )
}