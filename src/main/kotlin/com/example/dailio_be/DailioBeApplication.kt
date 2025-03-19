package com.example.dailio_be

import com.example.dailio_be.global.security.jwt.JwtProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(JwtProperty::class)
@SpringBootApplication
class DailioBeApplication

fun main(args: Array<String>) {
    runApplication<DailioBeApplication>(*args)
}
