#Kafka Producer Application
![kafka_producer documentation](https://github.com/AysCeren/kafka_producer/assets/154695340/ef48429c-6af2-4447-ae41-4a38de884034)

##*What is Kafka?
Apache Kafka is a distributed data store optimized for ingesting and processing streaming data in real-time. It is a Scala and Java application frequently used for big data analytics and real-time event stream processing.
!!!It is a Scala and Java application frequently used for big data analytics and real-time event stream processing.

###Main Functions:
    *Publish and subscribe to streams of records
    *Effectively store streams of records in the order in which records were generated
    *Process streams of records in real time

Because Kafka is a distributed event streaming platform, it captures precisely what occurred and when using streaming data. This file is known as an immutable commit log. It may be added to but cannot be altered, making it immutable.Those logs are stored in topics and Kafka topics are retained according to configurable retention policies. These policies can be time-based (e.g., retain records for 7 days) or size-based (e.g., retain up to 10 GB of records per partition).

![dökü2](https://github.com/AysCeren/kafka_producer/assets/154695340/e1f76697-06de-439a-8153-a1beb832bf14)
##Important to ask :)
###What is an event?
In the context of Kafka, when a producer sends a message to a Kafka topic, it represents a change in the state of the system – namely, the addition of new data to the topic. When you read or write data to Kafka, you do this in the form of events. Conceptually, an event has a key, value, timestamp, and optional metadata headers.
###What is a topic?
Topics are storage areas, keeping messages that producers send and consumers read, similar to log as data structure. With each partition of a Kafka topic, messages are stored and consumed * in the order they are produced *.
###What is a broker?
The Kafka broker is used for managing the storage of the data records/messages in the topic. We define a Kafka cluster when there is more than one broker present. The Kafka broker is responsible for transferring the conversation that the publisher is pushing in the Kafka log commit and the subscriber shall be consuming these messages. 


##*Structure of Kafka:

*Kafka has three main components:
  
 *They are responsible for writing new events to partitions, serving reads on existing partitions, and replicating partitions among themselves. They don’t do any computation over messages or routiang of messages between topics.
      2. Kafka Consumers: 
      

      
