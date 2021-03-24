package com.codependent.sample.configuration

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import com.codependent.sample.mongodb.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.convert.MongoCustomConversions


/**
 * @author José A. Íñigo
 */
@Configuration
class MongoDbClientConfiguration(private val mongoProperties: MongoProperties,
                                 @Value("\${mongodb.database:test}") private val mongoDatabase: String) : AbstractReactiveMongoConfiguration() {

    override fun getMappingBasePackages(): MutableCollection<String> {
        return mutableListOf("com.codependent.sample.domain")
    }

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create(mongoProperties.uri)
    }

    override fun getDatabaseName(): String {
        return mongoDatabase
    }

    override fun customConversions(): MongoCustomConversions {
        val list = listOf(
                OffsetDateTimeReadConverter(),
                OffsetDateTimeWriteConverter(),
                LocalDateReadConverter(),
                LocalDateWriteConverter(),
                MonetaryAmountReadConverter(),
                MonetaryAmountWriteConverter())
        return MongoCustomConversions(list)
    }

    override fun autoIndexCreation(): Boolean {
        return mongoProperties.isAutoIndexCreation
    }

}
