package com.producer.kafka.controller;

import com.producer.kafka.dto.Contact;
import com.producer.kafka.kafka.JsonKafkaProducer;
import com.producer.kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;
    public JsonMessageController(JsonKafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody List<Contact> contact) {
        System.out.println("in");
        for (Contact c : contact) {
            System.out.println(c.toString());
        } //Note: In this example we can save our data as proper as our database. There is no problem
        kafkaProducer.sendMessage(contact);
        System.out.println("out");
        return ResponseEntity.ok("JSON Message published");
    }
}
