package com.golmal.repo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = arrayOf(MongoAutoConfiguration::class,MongoDataAutoConfiguration::class))
class GolmalRepositoriesApplication

fun main(args: Array<String>) {
	runApplication<GolmalRepositoriesApplication>(*args)
}
