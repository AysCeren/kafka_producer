package com.producer.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
//Note: If we are not using Kafka, we should configure KafkaTemplate, with factories etc.
    private KafkaTemplate<String,String> kafkaTemplate;
    //CONSTRUCTOR BASED APPLICATION
    public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Sending message: %s", message));
        kafkaTemplate.send("kafka_streaming", message);

    }
}
