package com.example.dailio_be.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "jwt", ignoreInvalidFields = false)
data class JwtProperty @ConstructorBinding constructor(
        val secretKey: String,
        val accessExp: Long,
        val refreshExp: Long,
        val header: String,
        val prefix: String
)
