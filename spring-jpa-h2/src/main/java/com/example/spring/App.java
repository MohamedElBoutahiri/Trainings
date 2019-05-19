package com.example.spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mohamed El Boutahiri
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String... a) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		List<House> houses=Arrays.asList(new House());
		
		HouseRepository houseRepo=context.getBean(HouseRepository.class);
		houses.get(0).setPeopleNumber(5);
		houseRepo.saveAll(houses);
		
		for(House house: houseRepo.findAll()) {
			System.out.println(house);
		}
	}

}
