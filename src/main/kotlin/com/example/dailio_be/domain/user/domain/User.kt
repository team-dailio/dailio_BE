package com.example.dailio_be.domain.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var accountId: String = "",

    var password: String = "",
) {
    constructor() : this(
            (0),
            "",
            ""
    )
}