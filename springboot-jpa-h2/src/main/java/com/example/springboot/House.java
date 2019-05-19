package com.example.springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class House {

	@Id
	@GeneratedValue
	public Long Id;

	private int PeopleNumbers;

	public House() {}
	public House(int peopleNumbers) {
		PeopleNumbers = peopleNumbers;
	}

	public int getPeopleNumbers() {
		return PeopleNumbers;
	}

	public void setPeopleNumbers(int peopleNumbers) {
		PeopleNumbers = peopleNumbers;
	}

}
