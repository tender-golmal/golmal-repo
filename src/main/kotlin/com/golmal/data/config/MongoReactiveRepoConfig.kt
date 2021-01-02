package com.golmal.data.config

import com.mongodb.ConnectionString
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import com.mongodb.reactivestreams.client.MongoClients

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.connection.netty.NettyStreamFactoryFactory

import com.mongodb.MongoClientSettings
import org.springframework.boot.autoconfigure.mongo.MongoProperties


@Configuration
@EnableReactiveMongoRepositories("com.golmal.data.repo")
class MongoReactiveRepoConfig(val mongoProperties: MongoProperties): AbstractReactiveMongoConfiguration(){
    override fun getDatabaseName(): String ="golmaldb"
    override fun reactiveMongoClient(): MongoClient {
        // Instantiate MongoClient with default settings: mongodb://localhost
        val settings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString("mongodb://${mongoProperties.host}:${mongoProperties.port}/${mongoProperties.database}"))
            .build()

        return MongoClients.create(settings)
    }

}