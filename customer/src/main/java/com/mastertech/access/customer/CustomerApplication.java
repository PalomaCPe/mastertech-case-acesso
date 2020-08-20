package com.mastertech.access.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
