package com.test.adstracking.model;

import javax.persistence.Entity;

@Entity
public class Garage extends Space {
	
	public Garage() {}
	public Garage(Long size) {
		super.size=size;
	}
}
