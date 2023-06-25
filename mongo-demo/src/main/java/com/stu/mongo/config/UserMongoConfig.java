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
public class UserMongoConfig {

    @Resource(name = "userMongoProperties")
    private MongoProperties mongoProperties;

    @Bean(name = "userDbFactory")
    public MongoDbFactory dbFactory() {
        return new SimpleMongoClientDbFactory(mongoProperties.getUri());
    }

    @Bean(name = "userMongo")
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(this.dbFactory());
    }

    @Bean(name = "userMongoTransaction")
    public MongoTransactionManager transactionManager(){
        return new MongoTransactionManager(this.dbFactory());
    }
}
