package com.example.dailio_be.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank

data class LoginRequest(

        @NotBlank(message = "5자 이상, 10자 이하여야 합니다.")
        var accountId: String,

        @NotBlank(message = "5자 이상 영어, 문자, 특수문자가 포함되어야 합니다.")
        var password: String
)
