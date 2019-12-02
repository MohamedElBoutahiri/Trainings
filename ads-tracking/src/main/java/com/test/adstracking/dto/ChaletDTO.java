package com.test.adstracking.dto;

public class ChaletDTO extends SpaceDTO {
	
	private Long gardenSize;
	
	public ChaletDTO() {
	}

	public ChaletDTO(Long size, Long gardenSize) {
		super.size = size;
	}

	public Long getGardenSize() {
		return gardenSize;
	}

	public void setGardenSize(Long gardenSize) {
		this.gardenSize = gardenSize;
	}
}
