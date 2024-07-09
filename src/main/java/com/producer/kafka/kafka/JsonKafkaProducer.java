package com.producer.kafka.kafka;
//imports
import com.producer.kafka.dto.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //to make this class as a Spring Bean
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, Contact> kafkaTemplate;
    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, Contact> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(List<Contact> contact)
    {
        LOGGER.info(String.format("Sending message to Kafka: %s", contact.toString()));
        for (Contact c : contact) {
            System.out.println(c.toString());
        }
        Message<List<Contact>> message = MessageBuilder
                .withPayload(contact)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        System.out.println("message:" + message);
        kafkaTemplate.send(message);
        //There are more than one form of the send method.
        // We have configured necessary info in Message Class,
        // used the send function in the form of send(<Message>)
        System.out.println("Message sent to Kafka topic Ceren");
    }
}
