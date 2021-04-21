package com.example.PowerliftingResults;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.PowerliftingResults.domain.Result;
import com.example.PowerliftingResults.domain.ResultRepository;
import com.example.PowerliftingResults.domain.User;
import com.example.PowerliftingResults.domain.UserRepository;


public class ResultRepositoryTest {
	
	@Autowired
	private ResultRepository repository;
	private UserRepository urepository;

	@Test
	public void findByAuthorShouldRetrunBook() {
		List<Result> results = repository.findBylift("kyykky");

		assertThat(results).hasSize(1);
		assertThat(results.get(0).getLift()).isEqualTo("kyykky");
	}

	@Test
	public void createNewResult() {
		
		User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "email1");
		User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "email2");
				urepository.save(user1);
				urepository.save(user2);  
				
		Result result = new Result("maastaveto", 130 , "RPE10", "1", LocalDate.of(2021, 03, 21), user2);
		repository.save(result);
		assertThat(result.getResultid()).isNotNull();
	}

}


