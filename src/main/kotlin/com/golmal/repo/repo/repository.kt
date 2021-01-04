package com.golmal.repo.repo

import com.golmal.data.domain.UserProfile
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository: ReactiveMongoRepository<UserProfile,String> {
    fun findByEmail(email:String): Mono<UserProfile?>
}