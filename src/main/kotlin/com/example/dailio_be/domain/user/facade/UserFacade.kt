package com.example.dailio_be.domain.user.facade

import com.example.dailio_be.domain.user.domain.User
import com.example.dailio_be.domain.user.domain.repository.UserRepository
import com.example.dailio_be.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
        private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        return getByAccountId(accountId)
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId)
                ?:throw UserNotFoundException
    }

    fun checkUserExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

}