package com.test.adstracking.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.test.adstracking.enums.PictureQuality;

@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String url;

	@Enumerated(EnumType.STRING)
	private PictureQuality quality;

	public Picture() {
	}

	public Picture(String url, PictureQuality quality) {
		this.url = url;
		this.quality = quality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PictureQuality getQuality() {
		return quality;
	}

	public void setQuality(PictureQuality quality) {
		this.quality = quality;
	}
}
