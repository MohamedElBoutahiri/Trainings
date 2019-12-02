package com.test.adstracking.model;

import javax.persistence.Entity;

@Entity
public class Chalet extends Space {

	
	private Long gardenSize;
	
	public Chalet() {
	}

	public Chalet(Long size, Long gardenSize) {
		super.size = size;
	}

	public Long getGardenSize() {
		return gardenSize;
	}

	public void setGardenSize(Long gardenSize) {
		this.gardenSize = gardenSize;
	}
}
