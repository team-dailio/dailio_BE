package com.example.dailio_be.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.UUID

@Entity
class User(
        accountId: String,
        password: String,
        email: String
) {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(nullable = false, updatable = false, unique = true)
    val id: UUID = UUID.randomUUID()

    @Column(nullable = false, unique = true)
    var accountId: String = accountId
        protected set

    @Column(nullable = false)
    var password: String = password
        protected set

    var email: String = email
        protected set
}