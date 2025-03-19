package com.example.dailio_be.domain.user.domain

import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refresh_token", timeToLive = 60 * 60 * 2)
class RefreshToken(
        @Id
        val accountId: String,

        @Indexed
        @field:NotBlank
        var refreshToken: String
)