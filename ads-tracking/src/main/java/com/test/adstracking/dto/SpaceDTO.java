package com.test.adstracking.dto;

public class SpaceDTO {

	private Long id;

	public Long size;
	
	private String typeOfSpace;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getTypeOfSpace() {
		return typeOfSpace;
	}

	public void setTypeOfSpace(String typeOfSpace) {
		this.typeOfSpace = typeOfSpace;
	}

}
