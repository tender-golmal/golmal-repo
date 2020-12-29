package com.golmal.data.config

import com.mongodb.ConnectionString
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import com.mongodb.reactivestreams.client.MongoClients

import com.mongodb.reactivestreams.client.MongoClient




@Configuration
@EnableReactiveMongoRepositories("com.golmal.data.repo")
class MongoReactiveRepoConfig: AbstractReactiveMongoConfiguration(){
    override fun getDatabaseName(): String ="golmaldb"
    override fun reactiveMongoClient(): MongoClient {
        // Instantiate MongoClient with default settings: mongodb://localhost

        return MongoClients.create(ConnectionString("mongodb://localhost:27017/golmaldb"))
    }

}