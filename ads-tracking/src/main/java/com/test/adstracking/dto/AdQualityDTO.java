package com.test.adstracking.dto;

import java.util.Date;
import java.util.List;

public class AdQualityDTO extends AdDTO {

	private Date lastDateUpdate;

	public AdQualityDTO() {
		super();

	}

	public AdQualityDTO(String description, List<PictureDTO> pictures, Integer score, SpaceDTO Place,
			Date lastDateUpdate) {
		super(description, pictures, score, Place);
		this.lastDateUpdate=lastDateUpdate;

	}

	public Date getLastDateUpdate() {
		return lastDateUpdate;
	}

	public void setLastDateUpdate(Date lastDateUpdate) {
		this.lastDateUpdate = lastDateUpdate;
	}

	
}
