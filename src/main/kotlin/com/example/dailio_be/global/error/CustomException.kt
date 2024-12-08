package com.example.dailio_be.global.error

open class CustomException(
        private val error: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}