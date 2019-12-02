package com.test.adstracking.model;

import javax.persistence.Entity;

@Entity
public class Flat extends Space {


	public Flat() {
	}

	public Flat(Long size) {
		super.size = size;
	}

}
