package com.example.PowerliftingResults.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository <Result, Long> {
	
	public List<Result> findBylift(String lift);
	public List<Result> findByUser(User user);
	public Result findByResultid(Long resultid);
	
	}

	


