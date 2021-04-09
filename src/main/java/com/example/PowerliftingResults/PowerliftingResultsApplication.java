package com.example.PowerliftingResults;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.PowerliftingResults.domain.Result;
import com.example.PowerliftingResults.domain.ResultRepository;
import com.example.PowerliftingResults.domain.User;
import com.example.PowerliftingResults.domain.UserRepository;

@SpringBootApplication
public class PowerliftingResultsApplication {
	private static final Logger log = LoggerFactory.getLogger(PowerliftingResultsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PowerliftingResultsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Results(ResultRepository repository, UserRepository urepository) {
		return (args) -> {
			
			User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "email");
			User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "email");
					urepository.save(user1);
					urepository.save(user2);
			
			log.info("Save a few lifts");
			
			
			repository.save(new Result("maastaveto", "130kg", "RPE9", "31.3.2021", "1"));
			repository.save(new Result("penkkipunnerrus", "72,5kg", "RPE9", "29.3.2021", "1"));	
			repository.save(new Result("kyykky", "130kg", "RPE10", "28.1.2021", "3"));
			
			log.info("fetch all lifts");
			for (Result result : repository.findAll()) {
				log.info(result.toString());
			}

		};

}

}
