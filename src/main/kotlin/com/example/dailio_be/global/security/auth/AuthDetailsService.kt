package com.example.dailio_be.global.security.auth

import com.example.dailio_be.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
        private val userFacade: UserFacade
) : UserDetailsService {
    override fun loadUserByUsername(accounId: String): UserDetails {
        val user = userFacade.getByAccountId(accounId)
        return AuthDetails(user)
    }
}