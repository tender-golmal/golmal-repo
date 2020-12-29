package com.golmal.data.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class UserProfile(
    @Id
    val email:String,
    var firstName:String?,
    var lastName:String?,
    var passwordHash:String,
    var passwordSalt:String
)
