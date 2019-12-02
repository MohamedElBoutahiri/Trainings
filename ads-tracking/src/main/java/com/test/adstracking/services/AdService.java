package com.test.adstracking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.adstracking.model.Ad;
import com.test.adstracking.model.Chalet;
import com.test.adstracking.model.Garage;

/**
 * The adService represents the interface of the basic operations about the ads.
 * 
 * @author Mohamed El Boutahiri
 */

@Service
public interface AdService {

	public void calculateScore();


	public List<Ad> getAdsByScoreGreaterThanEqual(int score, int nPage);

	public List<Ad> getAdsByScoreLessThan(int score, int nPage);

	/**
	 * This method checks if an ad is complete.
	 * @param ad
	 * @return boolean
	 */
	public static boolean isComplete(Ad ad) {

		if (!(ad.getPlace() instanceof Garage) && (ad.getDescription() == null || ad.getDescription().isEmpty())) {
			return false;
		} else if (ad.getPictures().isEmpty()) {
			return false;
		} else if (ad.getPlace().getSize()==null) {
			return false;
		} else if (ad.getPlace() instanceof Chalet && ((Chalet) ad.getPlace()).getGardenSize()==null) {
			return false;
		} 
		return true;
	}

}
