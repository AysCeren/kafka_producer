/*
package com.producer.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration //this is creating bean, in here.
public class KafkaTopicConfig {
    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("testTopic2")
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic kafkaJsonTopic(){
        return TopicBuilder.name("myJsonTopic")
                .partitions(1)
                .build();
    }
}
*/