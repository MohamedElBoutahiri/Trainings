package com.test.adstracking.services;

import com.test.adstracking.model.Ad;
import org.springframework.stereotype.Service;

/**
 * The service class to handle operation about scores
 * @author Mohamed El Boutahiri
 *
 */

@Service
public interface ScoreService {
	
	/**
	 * Method which calculates a score given an ad
	 * @param ad
	 * @return score
	 */
	public int calculateScorePerAd(Ad ad);
}
