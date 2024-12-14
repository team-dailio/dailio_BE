package com.example.dailio_be.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import kotlin.Throws

@Component
class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    @Throws(IOException::class)
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: CustomException) {
            val errorCode = e.errorCode
            val errorResponse = ErrorResponse(errorCode.status, errorCode.message)
        }
    }

    @Throws(IOException::class)
    private fun writeErrorResponse(
            response: HttpServletResponse,
            status: Int,
            errorResponse:
                ErrorResponse
    ) {
        response.status = status
        response.contentType = "application/json"
        objectMapper.writeValue(response.writer, errorResponse)
    }
}