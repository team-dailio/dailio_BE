package com.example.dailio_be.domain.user.presentation

import com.example.dailio_be.domain.user.presentation.dto.request.LoginRequest
import com.example.dailio_be.domain.user.presentation.dto.request.SignUpRequest
import com.example.dailio_be.domain.user.service.LoginService
import com.example.dailio_be.domain.user.service.SignUpService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
        private val signUpService: SignUpService,
        private val loginService: LoginService
) {
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    fun signup(
            @RequestBody @Valid
            request: SignUpRequest
    ) = signUpService.execute(request)

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(
            @RequestBody @Valid
            request: LoginRequest
    ) = loginService.execute(request)
}