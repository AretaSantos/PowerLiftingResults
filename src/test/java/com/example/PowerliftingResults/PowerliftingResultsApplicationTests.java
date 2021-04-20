package com.example.PowerliftingResults;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.PowerliftingResults.web.PowerliftingResultsContoller;

@SpringBootTest
class PowerliftingResultsApplicationTests {

	@Autowired
	private PowerliftingResultsContoller controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	
}
