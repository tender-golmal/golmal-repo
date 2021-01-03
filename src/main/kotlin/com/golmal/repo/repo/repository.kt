package com.golmal.repo.repo

import com.golmal.data.domain.UserProfile
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: ReactiveMongoRepository<UserProfile,String> {
}