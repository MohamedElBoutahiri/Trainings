package com.test.adstracking.dto;

import com.test.adstracking.enums.PictureQuality;

public class PictureDTO {

	
	private Long id;
	private String url;

	private PictureQuality quality;

	public PictureDTO() {
	}

	public PictureDTO(Long id, String url, PictureQuality quality) {
		this.id = id;
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
