package com.example.dailio_be.global.error

enum class ErrorCode(
        val status: Int,
        val message: String
) {

    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),

    USER_NOT_FOUND(404, "User Not found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}