package com.test.adstracking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	
	
	@OneToMany (cascade = {CascadeType.ALL})
	private List<Picture> pictures;
	private Integer score;
	private Date lastDateUpdate;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Space place;

	public Ad() {
	}

	public Ad( String description, List<Picture> pictures, Integer score, Date lastDateUpdate, Space Place) {
		this.description = description;
		this.pictures = pictures;
		this.score = score;
		this.lastDateUpdate = lastDateUpdate;
		this.place = Place;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getlLastDateUpdate() {
		return lastDateUpdate;
	}

	public void setLastDateUpdate(Date lastDateUpdate) {
		this.lastDateUpdate = lastDateUpdate;
	}

	public Space getPlace() {
		return place;
	}

	public void setPlace(Space place) {
		this.place = place;
	}

}
