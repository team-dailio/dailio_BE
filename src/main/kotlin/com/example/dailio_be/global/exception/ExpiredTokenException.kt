package com.example.dailio_be.global.exception

import com.example.dailio_be.global.error.CustomException
import com.example.dailio_be.global.error.ErrorCode

object ExpiredTokenException : CustomException(ErrorCode.EXPIRED_TOKEN)