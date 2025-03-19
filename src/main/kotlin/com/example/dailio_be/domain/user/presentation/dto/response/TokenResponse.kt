package com.example.dailio_be.domain.user.presentation.dto.response

data class TokenResponse(
        val accessToken: String,
        val refreshToken: String
)
