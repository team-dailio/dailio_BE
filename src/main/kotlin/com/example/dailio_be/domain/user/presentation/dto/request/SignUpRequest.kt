package com.example.dailio_be.domain.user.presentation.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpRequest(

        @Size(min = 5, max = 10)
        @NotBlank(message = "5자 이상, 10자 이하여야 합니다.")
        var accountId: String,

        @NotBlank(message = "5자 이상 영어, 문자, 특수문자가 포함되어야 합니다.")
        @Pattern(regexp =  "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" +
                "?@]{8,20}$")
        var  password: String,

        var email: String
)
