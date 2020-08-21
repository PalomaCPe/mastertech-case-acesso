package com.br.mastertech.consumer;

import com.br.mastertech.access.producer.LogAccess;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;

@Service
public class AccessService {
	
    Logger logger = LoggerFactory.getLogger(AccessService.class);

	
	public void createEventLog(LogAccess logAccess) {
		
		try {
			BufferedWriter writer =  new BufferedWriter(new FileWriter("/home/a2w/projects/mastertech-case-acesso/consumer/src/main/java/com/br/mastertech/consumer/logAccess.csv", true));

			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
				System.out.println(logAccess != null);
			 csvPrinter.printRecord(
					 logAccess.getCustomerId()+" ",
					 logAccess.getDoorId()+" ",
					 logAccess.isHasAccess()+" ");
	         csvPrinter.flush();  
	         csvPrinter.close();
		}catch(Exception e) {
			logger.error("Erro ao criar evento", e);
		}
	}

}
