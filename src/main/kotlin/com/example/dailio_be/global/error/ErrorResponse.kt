package com.example.dailio_be.global.error

class ErrorResponse(
        val status: Int,
        val message: String
) {
    companion object {
        fun of(e:CustomException): ErrorResponse {
            return ErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }
}