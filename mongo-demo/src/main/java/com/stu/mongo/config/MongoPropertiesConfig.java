package com.stu.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 86177
 */
@Configuration
public class MongoPropertiesConfig {

    @Primary
    @Bean(name="orderMongoProperties")
    @ConfigurationProperties(prefix="spring.data.mongodb.order")
    public MongoProperties orderProperties() {
        return new MongoProperties();
    }

    @Bean(name="userMongoProperties")
    @ConfigurationProperties(prefix="spring.data.mongodb.user")
    public MongoProperties userProperties() {
        return new MongoProperties();
    }

}
