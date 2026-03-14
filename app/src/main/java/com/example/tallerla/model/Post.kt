package com.example.tallerla.model

data class Post(
    val id: Int,
    val username: String,
    val profileImageUrl: String,
    val imageUrl: String,
    val likes: Int,
    val caption: String,
    val isLiked: Boolean = false
)