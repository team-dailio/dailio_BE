package com.example.dailio_be.domain.user.controller.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)