package com.stu.mongo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import javax.annotation.Resource;

/**
 * @author 86177
 */
@Configuration
public class OrderMongoConfig {

    @Resource(name = "orderMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "orderDbFactory")
    public MongoDbFactory dbFactory() {
        return new SimpleMongoClientDbFactory(mongoProperties.getUri());
    }

    @Primary
    @Bean(name = "orderMongo")
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(this.dbFactory());
    }

    @Primary
    @Bean(name = "orderMongoTransaction")
    public MongoTransactionManager transactionManager(){
        return new MongoTransactionManager(this.dbFactory());
    }
}
