package com.example.dailio_be.global.error

enum class ErrorCode(
        val status: Int,
        val message: String
) {

    PASSWORD_MISMATCHED(401, "Password Mismatched"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),

    USER_NOT_FOUND(404, "User Not Found"),

    EXIST_USER(409, "Exist User"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}