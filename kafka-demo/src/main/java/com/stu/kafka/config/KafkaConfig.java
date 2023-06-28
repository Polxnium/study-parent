package com.stu.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topicOne() {
        return new NewTopic("ntp-01", 5, (short) 1);
    }
    @Bean
    public NewTopic topicTwo() {
        return new NewTopic("ntp-02", 3, (short) 1);
    }
}
