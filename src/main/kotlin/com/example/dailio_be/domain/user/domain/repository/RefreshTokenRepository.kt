package com.example.dailio_be.domain.user.domain.repository

import com.example.dailio_be.domain.user.domain.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshToken, String>