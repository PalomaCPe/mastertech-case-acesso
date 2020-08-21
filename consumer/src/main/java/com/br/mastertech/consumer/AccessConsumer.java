package com.br.mastertech.consumer;

import com.br.mastertech.access.producer.LogAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessConsumer {
    Logger logger = LoggerFactory.getLogger(AccessConsumer.class);

	@Autowired
	AccessService AccessService;
	
    @KafkaListener(topics = "access-consumer-paloma-1", groupId = "1")
	public void getEvent(@Payload LogAccess access) throws IOException {
    	
    	logger.info("Recebendo evento: " + access.getCustomerId());
    	
    	AccessService.createEventLog(access);
	}

}
