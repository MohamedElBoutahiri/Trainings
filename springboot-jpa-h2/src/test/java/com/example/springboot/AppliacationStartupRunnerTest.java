package com.example.springboot;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppliacationStartupRunnerTest {

	@Autowired
	AppliacationStartupRunner app;
	
	@Test
	public void testRun() throws Exception {
		System.out.println(LocalDate.now());
		app.run();
	}

}
