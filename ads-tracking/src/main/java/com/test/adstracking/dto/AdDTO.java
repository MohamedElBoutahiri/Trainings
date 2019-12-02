package com.test.adstracking.dto;

import java.util.List;

public class AdDTO {

	private Long id;
	private String description;
	private List<PictureDTO> pictures;
	private Integer score;
	private SpaceDTO place;
	
	public AdDTO() {
	}

	public AdDTO(String description, List<PictureDTO> pictures, Integer score, SpaceDTO Place) {
		this.description = description;
		this.pictures = pictures;
		this.score = score;
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

	public List<PictureDTO> getPictures() {
		return pictures;
	}

	public void setPictures(List<PictureDTO> pictures) {
		this.pictures = pictures;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public SpaceDTO getPlace() {
		return place;
	}

	public void setPlace(SpaceDTO place) {
		this.place = place;
	}

}
