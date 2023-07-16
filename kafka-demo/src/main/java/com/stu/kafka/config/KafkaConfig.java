package com.stu.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置自定义主题，启动时会在Kafka自动创建主题相关信息
 */
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic1() {
        return new NewTopic("ntp-01", 5, (short) 1);
    }
    @Bean
    public NewTopic topic2() {
        return new NewTopic("ntp-02", 3, (short) 1);
    }
    @Bean
    public NewTopic topic3() {
        return new NewTopic("ntp-03", 3, (short) 1);
    }
}
