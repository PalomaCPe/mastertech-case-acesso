package com.br.mastertech.consumer;

import com.br.mastertech.acesso.producer.LogAcesso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AcessoConsumer {
	
    Logger logger = LoggerFactory.getLogger(AcessoConsumer.class);

	
	@Autowired
	AcessoService AcessoService;
	
    @KafkaListener(topics = "spec4-paloma-1", groupId = "1")
	public void recebeEvento(@Payload LogAcesso acesso) throws IOException {
    	
    	logger.info("Recebendo evento: " + acesso.getClienteId());
    	
    	AcessoService.criaEventoLog(acesso);
	}

}
