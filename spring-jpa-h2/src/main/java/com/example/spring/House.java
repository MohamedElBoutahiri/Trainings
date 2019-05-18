package com.example.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;

	private int PeopleNumbers;

	public int getPeopleNumbers() {
		return PeopleNumbers;
	}

	public void setPeopleNumber(int peopleNumbers) {
		PeopleNumbers = peopleNumbers;
	}

	@Override
	public String toString() {
		return "House [Id=" + Id + ", PeopleNumbers=" + PeopleNumbers + "]";
	}

}
