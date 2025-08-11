package com.example.AirportScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirportSchedulerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AirportSchedulerApplication.class, args);
//		context.getBean(DataReadService.class).printData();
	}

}
