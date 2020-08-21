package com.mastertech.access.access.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessLogProducer {
    @Autowired
    private KafkaTemplate<String, AccessLog> producer;

    public void sendToKafka(AccessLog accessLog) {

        producer.send("spec4-paloma-1", accessLog);
        producer.send("spec4-paloma-2", accessLog);
        producer.send("spec4-paloma-3", accessLog);

    }
}
