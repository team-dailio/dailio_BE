package com.example.dailio_be.global.security.jwt

import com.example.dailio_be.domain.user.domain.RefreshToken
import com.example.dailio_be.domain.user.domain.repository.RefreshTokenRepository
import com.example.dailio_be.domain.user.presentation.dto.response.TokenResponse
import com.example.dailio_be.global.exception.ExpiredTokenException
import com.example.dailio_be.global.exception.InternalServerErrorException
import com.example.dailio_be.global.exception.InvalidTokenException
import com.example.dailio_be.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
        private val jwtProperty: JwtProperty,
        private val authDetailsService: AuthDetailsService,
        private val refreshTokenRepository: RefreshTokenRepository
) {
    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateToken(accountId, jwtProperty.accessExp)
        val refreshToken: String = generateRefreshToken(accountId)

        return TokenResponse(accessToken = accessToken, refreshToken = refreshToken)
    }

    fun generateRefreshToken(accountId: String): String {
        val newRefreshToken: String = generateToken(accountId, jwtProperty.refreshExp)
        refreshTokenRepository.save(
                RefreshToken(
                        accountId = (accountId),
                        refreshToken = newRefreshToken
                )
        )
        return newRefreshToken
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return "Bearer" + Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperty.secretKey)
                .setSubject(accountId)
                .setHeaderParam("typ", "access")
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authorization")
        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "")
        } else null
    }
    fun authorization(token: String): UsernamePasswordAuthenticationToken? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun getTokenSubject(subject: String): String {
        return getTokenBody(subject).subject
    }

    private fun getTokenBody(token: String?): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperty.secretKey)
                    .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException
                is InvalidClaimException -> throw InvalidTokenException
                else -> throw InternalServerErrorException
            }
        }
    }
}