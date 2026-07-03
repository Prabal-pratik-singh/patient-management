package com.pm.patientservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//this class is responsible for sending events to given kafka topics
@Service
public class kafkaProducer {

    //THIS DEFINE  OUR MESSAGE TYPES AND WE USE KAFKA TEMPLATE TO SEND THOSE MSG TO KAFKA TOPIC FROM THIS PRODUCER
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String,byte[]> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
}
