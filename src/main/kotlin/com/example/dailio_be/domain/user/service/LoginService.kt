package com.example.dailio_be.domain.user.service

import com.example.dailio_be.domain.user.exception.PasswordMismatchedException
import com.example.dailio_be.domain.user.facade.UserFacade
import com.example.dailio_be.domain.user.presentation.dto.request.LoginRequest
import com.example.dailio_be.domain.user.presentation.dto.response.TokenResponse
import com.example.dailio_be.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoginService (
        private val userFacade: UserFacade,
        private val passwordEncoder: PasswordEncoder,
        private val jwtTokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userFacade.getByAccountId(request.accountId)
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchedException
        }
        return jwtTokenProvider.getToken(user.accountId)
    }
}