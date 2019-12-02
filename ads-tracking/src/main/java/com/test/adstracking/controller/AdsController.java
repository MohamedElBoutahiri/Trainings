package com.test.adstracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.adstracking.dto.AdDTO;
import com.test.adstracking.dto.AdQualityDTO;
import com.test.adstracking.model.Ad;
import com.test.adstracking.services.AdService;

/**
 * RestController with the endpoints to consume the data of ads.
 * @author Mohamed El Boutahiri
 *
 */
@RestController
@RequestMapping(path = "/ads")
public class AdsController {

	@Autowired
	AdService adService;

	@Autowired
	DozerBeanMapper dozer;
	
	/**
	 * Method to get the ads with a score less than 40, paginating the results.
	 * @param numPage
	 * @return List<AdQualityDTO> in the json format
	 */
	@GetMapping("/quality")
	public ResponseEntity<List<AdQualityDTO>> qualityListing(@RequestParam(required=false) Integer numPage) {
		List<Ad> ads = adService.getAdsByScoreLessThan(40, numPage==null?0:numPage);
		List<AdQualityDTO> adsDTO = new ArrayList<>();

		ads.stream().forEach(ad -> {
			AdQualityDTO adQ=dozer.map(ad, AdQualityDTO.class);
			adQ.setLastDateUpdate(ad.getlLastDateUpdate());
			adsDTO.add(adQ);
			});

		if (!adsDTO.isEmpty())
			return new ResponseEntity<List<AdQualityDTO>>(adsDTO, HttpStatus.OK);
		else
			return new ResponseEntity<List<AdQualityDTO>>(adsDTO, HttpStatus.NOT_FOUND);
	}
	/**
	 * Method to get the ads with a score greater or equals than 40, paginating the results.
	 * @param numPage
	 * @return List<AdQualityDTO> in the json format
	 */
	
	@GetMapping("/public")
	public ResponseEntity<List<AdDTO>> publicListing(@RequestParam(required=false) Integer numPage) {
		List<Ad> ads = adService.getAdsByScoreGreaterThanEqual(40, numPage==null?0:numPage);
		List<AdDTO> adsDTO = new ArrayList<>();

		ads.stream().forEach(ad -> adsDTO.add(dozer.map(ad, AdDTO.class)));

		if (!adsDTO.isEmpty())
			return new ResponseEntity<List<AdDTO>>(adsDTO, HttpStatus.OK);
		else
			return new ResponseEntity<List<AdDTO>>(adsDTO, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Method which calculates the scores for the all ads.
	 */
	@GetMapping("/calculate-score")
	@ResponseStatus(value = HttpStatus.OK)
	public void calculateScore() {
		adService.calculateScore();
	}

}
