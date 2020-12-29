package com.golmal.data.controller

import com.golmal.data.domain.UserProfile
import com.golmal.data.repo.UserRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getUsers():Flux<UserProfile>{
        return userRepository.findAll()
    }
    @PostMapping
    fun saveUser(@RequestBody userProfile: UserProfile):Mono<UserProfile>{
        return userRepository.save(userProfile);
    }

    @GetMapping("/{email}")
    fun getUser(@PathVariable email:String):Mono<UserProfile>{
        return userRepository.findById(email);
    }

    @PutMapping("/{email}")
    fun updateUser(@RequestBody userProfile: UserProfile,@PathVariable email: String): Mono<UserProfile>? {
        val found=userRepository.findById(email).block()
        found?.apply {
            firstName=userProfile.firstName
            lastName=userProfile.lastName
        }
        return found?.let { Mono.just(it) };
    }
}