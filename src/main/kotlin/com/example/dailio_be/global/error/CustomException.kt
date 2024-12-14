package com.example.dailio_be.global.error

open class CustomException(
        val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status
    override val message: String
        get() = errorCode.message

}