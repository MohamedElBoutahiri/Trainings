package com.test.adstracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
public class Space {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String typeOfSpace=this.getClass().getSimpleName();

	public Long size;

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
