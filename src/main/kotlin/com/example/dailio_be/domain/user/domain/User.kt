package com.example.dailio_be.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(
        id: Long?,
        accountId: String,
        password: String,
        email: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    @Column(nullable = false, unique = true)
    var accountId: String = accountId
        protected set

    @Column(nullable = false)
    var password: String = password
        protected set

    var email: String = email
        protected set
}