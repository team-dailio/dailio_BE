package com.example.dailio_be.domain.user.service

import com.example.dailio_be.domain.user.domain.User
import com.example.dailio_be.domain.user.domain.repository.UserRepository
import com.example.dailio_be.domain.user.exception.ExistUserException
import com.example.dailio_be.domain.user.facade.UserFacade
import com.example.dailio_be.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
        private val userRepository: UserRepository,
        private val userFacade: UserFacade,
        private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: SignUpRequest) {
        if (userFacade.checkUserExist(request.accountId)) {
            throw ExistUserException
        }


        userRepository.save(
                User(
                        accountId = request.accountId,
                        password = passwordEncoder.encode(request.password),
                        email = request.email
                )
        )
    }
}