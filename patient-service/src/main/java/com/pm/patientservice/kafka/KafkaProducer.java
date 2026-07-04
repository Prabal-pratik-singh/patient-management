package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

//this class is responsible for sending events to given kafka topics
@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    //THIS DEFINE  OUR MESSAGE TYPES AND WE USE KAFKA TEMPLATE TO SEND THOSE MSG TO KAFKA TOPIC FROM THIS PRODUCER
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String,byte[]> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendEvent(Patient patient) {
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();
        try {
            log.info("Sending patient event: {}", event);

            kafkaTemplate.send("patient",event.toByteArray());

            log.info("Event sent successfully");
        } catch (Exception e) {
            log.error("Error sending PatientCreated event:{}" ,event);
        }
    }
}
