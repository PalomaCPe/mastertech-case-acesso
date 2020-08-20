package com.mastertech.access.door;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class DoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorApplication.class, args);
	}

}
