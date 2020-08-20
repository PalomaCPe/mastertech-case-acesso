package com.br.mastertech.consumer;

import com.br.mastertech.acesso.producer.LogAcesso;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;

@Service
public class AcessoService {
	
    Logger logger = LoggerFactory.getLogger(AcessoService.class);

	
	public void criaEventoLog(LogAcesso logAcesso) {
		
		try {
			BufferedWriter writer =  new BufferedWriter(new FileWriter("/home/a2w/Documentos/projects/Servicos/consumer/src/main/java/com/br/mastertech/consumer/logAcesso.csv", true));

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
				System.out.println(logAcesso != null);
			 csvPrinter.printRecord(
					 logAcesso.getClienteId()+" ",
					 logAcesso.getPortaId()+" ",
					 logAcesso.possuiAcesso()+" ");
	         csvPrinter.flush();  
	         csvPrinter.close();
		}catch(Exception e) {
			logger.error("Erro ao criar evento", e);
		}
		 

	}

}
