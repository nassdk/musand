package com.nassdk.musand.domain.model

data class AuthResponse(
    val token: String,
    val expiresTime: String,
    val refreshToken: String
)