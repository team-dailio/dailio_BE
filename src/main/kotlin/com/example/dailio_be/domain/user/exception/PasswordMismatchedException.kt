package com.example.dailio_be.domain.user.exception

import com.example.dailio_be.global.error.CustomException
import com.example.dailio_be.global.error.ErrorCode

object PasswordMismatchedException : CustomException(ErrorCode.PASSWORD_MISMATCHED)