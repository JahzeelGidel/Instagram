package com.example.tallerla.model

data class Story(
    val id: Int,
    val username: String,
    val profileImageUrl: String,
    val hasSeen: Boolean = false
)