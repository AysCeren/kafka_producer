# Kafka Producer Application
![kafka_producer documentation](https://github.com/AysCeren/kafka_producer/assets/154695340/ef48429c-6af2-4447-ae41-4a38de884034)

## What is Kafka?
Apache Kafka is a distributed data store optimized for ingesting and processing streaming data in real-time. It is a Scala and Java application frequently used for big data analytics and real-time event stream processing. The project aims to provide a unified, high-throughput, low-latency platform for handling real-time data feeds. Producers are publishing, consumers are subscribing in this application.
!!!It is a Scala and Java application frequently used for big data analytics and real-time event stream processing.

### Main Functions:
    *Publish and subscribe to streams of records
    *Effectively store streams of records in the order in which records were generated
    *Process streams of records in real time

Because Kafka is a distributed event streaming platform, it captures precisely what occurred and when using streaming data. This file is known as an immutable commit log. It may be added to but cannot be altered, making it immutable.Those logs are stored in topics and Kafka topics are retained according to configurable retention policies. These policies can be time-based (e.g., retain records for 7 days) or size-based (e.g., retain up to 10 GB of records per partition).


## Important Questions Components of KAFKA:
### What is an event?
In the context of Kafka, when a producer sends a message to a Kafka topic, it represents a change in the state of the system – namely, the addition of new data to the topic. When you read or write data to Kafka, you do this in the form of events. Conceptually, an event has a key, value, timestamp, and optional metadata headers.
### What is a topic?
Topics are storage areas, keeping messages that producers send and consumers read, similar to log as data structure. With each partition of a Kafka topic, messages are stored and consumed **in the order they are produced**.
### What is partitions in a Kafka topic?
One topic can be splitted into multiple partitions. Kafka distributes the partitions of a particular topic across multiple brokers. That's why Kafka is scalable and benefits from parallelism between partitions.Kafka also replicates partitions and spreads the replicas across the cluster.  This provides robust fault tolerance; if one broker fails other brokers can take over and pick up where the failed machine left off.

![1_9Qm9qjZbvfV0X1pAlUUxcw](https://github.com/AysCeren/kafka_producer/assets/154695340/f87dab7d-cf72-4a67-b679-47e2fb2ef627)

### What is a broker?
The Kafka broker is used for managing the storage of the data records/messages in the topic. We define a Kafka cluster when there is more than one broker present. The Kafka broker is responsible for transferring the conversation that the publisher is pushing in the Kafka log commit and the subscriber shall be consuming these messages. 
### What is Zookeeper?
ZooKeeper handles the leadership election of Kafka brokers and manages service discovery as well as cluster topology so each broker knows when brokers have entered or exited the cluster, when a broker dies and who the preferred leader node is for a given topic/partition pair.
### What is this data producers writing to topic?

## Main Goal of This Project: 
Kafka is pub/sub application, therefore, its main structure is composed of producers -write data to Kafka Topics (publish) and consumers -read data from Kafka Topics (subscribe). This project aims 3 things:

      *Creating kafka topics
      *Taking PostMapping with @RequestMapping bean
      *Writing data to kafka


>Technologies of this project:
>Java,
>Spring Boot,
>Maven


That's why you may want to use https://start.spring.io/ to initalize your file structure.
![image](https://github.com/AysCeren/kafka_producer/assets/154695340/d03a740a-63e8-4359-94e2-e61b0f598b74)



## Understanding Producers of Kafka:
'JsonMessageController' class in the controller package and 'JsonKafkaProducer' class in the kafka package are the main classes and they are communication with each other. The aim of JSON message controller is controlling for the Post Requests coming from Postman this is an example for this project, and sending the data with the object of class JsonKafkaProducer.

// Response Entity function is taking message, forming it as a Contact object, and calling sendMessage() method of JsonKafkaProducer
```
@PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody List<Contact> contact) {
        kafkaProducer.sendMessage(contact);
        return ResponseEntity.ok("JSON Message published");
    }
```
#### Notice for JSON structure:

The message coming with PostMan is a post request and it is adapted as JSON raw data. It is possible to read data from PostMan as JSON, but because we have a Contact class we want to Serialize data as Contact object. This is handled by @RequestBody annotation. To be able to have this convertion, we should include 
Serializer for the spring kafka producer, as JSONserializer.

```
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
```
#### Notice for KafkaTemplate Class:

After object has been sent to the sendMessage method of JSONKafkaProducer, it is ready to be written into KafkaTopics. Built'in method is used to write into topics.

```
public void sendMessage(List<Contact> contact)
    {
        LOGGER.info(String.format("Sending message to Kafka: %s", contact.toString()));
        Message<List<Contact>> message = MessageBuilder
                .withPayload(contact)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        kafkaTemplate.send(message); //this is the part when message is written into topic
    }
```
!It is possible to use kafkaTemplate.send("test", contacts); to sent data. The Message class allows additional Payloads etc.

## Problems coders may face: 
+ It is important to run zookeeper and kafka servers. (You can check repository to look at KAFKA INSTALLATION)
+ The ports of the application should be controlled, as a default it will run on 9092 port. Can be changed in the application.properties file: spring.kafka.producer.bootstrap-servers=localhost:xxxx 

## How can we create data?

Kafka is a middleman between producers & consumers. Producers are writing data to topic, consumers are consuming data from topic by using Kafka. However, it is important to note that producers are pulling data from another service. e.g.: sensors, mobile application, another database.

**Producers sources, including:**

         1. Databases: Producers can read data from databases and send it to Kafka. This can be done through database change data capture (CDC) tools or custom applications.
         2. Applications: Applications can generate events based on user actions, transactions, or other application-specific triggers and send these events to Kafka.
         3. Logs and Metrics: Producers can read log files or metrics from monitoring systems and produce these records to Kafka topics.
         4. Sensors and IoT Devices: Data from sensors and IoT devices can be sent to Kafka via producers.
         

![image](https://github.com/user-attachments/assets/dcd0fd27-e6e2-4e7e-b6fa-a630dcde3b3f)

**NOTE**: We are using postman to release a data that can be pulled by Kafka Producers. However, possible sources and so on are listed above.
### Postman Request Structure:

![image](https://github.com/user-attachments/assets/a61795c8-1040-442e-b112-8879b28edafb)


We should choose valid request form: 
```
@PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody List<Contact> contact) {
        kafkaProducer.sendMessage(contact);
```
+ Because our application is waiting for $PostMapping, we are sending 'Post' request from PostMan.
+ We should determine the port address by looking in which port is assigned to our program.
        - It is possible to control from: Tomcat started on port 8080 (http) with context path '/', the port number is '8080' by default.
        - You can change by writing: server.port = xxxx
