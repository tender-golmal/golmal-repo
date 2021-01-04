package com.golmal.repo.extensions

import com.golmal.data.domain.Role
import com.golmal.data.domain.RoleType
import com.golmal.data.domain.UserProfile
import com.golmal.data.dto.RegisterRequest

fun RegisterRequest.toUserProfile()= UserProfile(
        id=null,
        email=email,
        firstName = firstName,
        lastName = secondName,
        password = password,
        roles = arrayListOf(Role(id = null,role = RoleType.ROLE_USER))
    )
