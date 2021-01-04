package com.golmal.repo.controller


import com.golmal.data.domain.UserProfile
import com.golmal.data.dto.RegisterRequest
import com.golmal.repo.extensions.toUserProfile
import com.golmal.repo.repo.UserRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getUsers():Flux<UserProfile> =
        userRepository.findAll()

    @PostMapping
    fun saveUser(@Valid @RequestBody request: RegisterRequest):Mono<UserProfile> =
        userRepository.insert(request.toUserProfile());


    @GetMapping("/{email}")
    fun getUser(@Email @NotEmpty @PathVariable email:String):Mono<UserProfile?> =
         userRepository.findByEmail(email);


    @PutMapping("/{email}")
    fun updateUser(@RequestBody userProfile: UserProfile,@Email @NotEmpty @PathVariable email: String): Mono<UserProfile>? {
        val found=userRepository.findByEmail(email).block()
        found?.apply {
            firstName=userProfile.firstName
            lastName=userProfile.lastName
        }
        return found?.let { Mono.just(it) };
    }
}