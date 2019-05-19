package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Mohamed El Boutahiri
 *
 */
@Component
public class AppliacationStartupRunner implements CommandLineRunner {

	@Autowired
	private HouseRepositoryyy repo;
	
	@Override
	public void run(String... args) throws Exception {

		repo.save(new House(23));
		System.out.println(repo.findAll());

	}
}