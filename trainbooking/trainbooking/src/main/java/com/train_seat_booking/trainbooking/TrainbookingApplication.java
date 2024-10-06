package com.train_seat_booking.trainbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller","model","securityconfig","service"} )
@EnableJpaRepositories("repository")
public class TrainbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainbookingApplication.class, args);
	}

}
