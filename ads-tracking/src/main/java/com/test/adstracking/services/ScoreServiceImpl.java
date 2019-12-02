package com.test.adstracking.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.adstracking.enums.PictureQuality;
import com.test.adstracking.model.Ad;
import com.test.adstracking.model.Flat;
import com.test.adstracking.model.Chalet;
import com.test.adstracking.util.TextUtils;

@Service
public class ScoreServiceImpl implements ScoreService {

	public final static List<String> KEY_WORDS = Arrays.asList("luminoso", "reformado", "ático", "nuevo", "céntrico");

	// We can use constants to have all the scores and the number of words.
	// Because of time, we will try to focus in the other requirements.
	// public final static int NON_PICTURE_SCORE=-10;
	// public final static int HD_PICTURE_SCORE=20;
	// public final static int HAS_DESCRIPTION_SCORE=5;
	// public final static int SCORE_WORDS_20_49=10;
	// public final static int SCORE_WORDS_APP_50_MORE=30;
	// public final static int SCORE_WORDS_CHALET_50_MORE=20;

	@Override
	public int calculateScorePerAd(Ad ad) {

		int score = 0;
		score = calculateScoreByImages(ad);
		score += calculateScoreByDescription(ad);
		score += calculateScoreIfAdIsComplete(ad);
		
		
		return score<0?0:(score>100?100:score);

	}
	
	/**
	 * Gets a score by images given an ad.
	 * @param ad
	 * @return score.
	 */
	public int calculateScoreByImages(Ad ad) {

		int score = 0;
		long nPictures = 0;
		long nPicturesHD = 0;

		nPictures = ad.getPictures().size();
		nPicturesHD = ad.getPictures().stream().filter(picture -> picture.getQuality().equals(PictureQuality.HD))
				.count();

		score = (int) (nPicturesHD * 20 + (nPictures - nPicturesHD) * 10);
		score = score == 0 ? -10 : score;

		return score;

	}
	
	/**
	 * Gets a score by the CONTENT OF THE DESCRIPTION given an ad.
	 * @param ad
	 * @return score.
	 */
	private int calculateScoreByDescription(Ad ad) {
		int score = 0;
		String description = ad.getDescription();
		String[] words = null;
		if (description == null || description.isEmpty())
			return 0;
		else {
			words = TextUtils.getWordsFromText(description);
			score = getScoreByNumberOfWords(words, ad);
			score += getScoreByListOfWords(words, KEY_WORDS);
			return score;
		}

	}
	
	/**
	 * Gets a score by a list of keywords. The method searches in the array  words for the keywords
	 * @param words words to search for the keywords
	 * @param keywords which gives points if it's in the words array
	 * @return score
	 */
	private int getScoreByListOfWords(String[] words, List<String> keywords) {
		int score = 0;
		for (String word : keywords)
			score += Arrays.stream(words).anyMatch(word::equalsIgnoreCase) ? 5 : 0;

		return score;

	}
	
	/**
	 * Gets a score by a number of words.
	 * @param words words to search for the keywords
	 * @param ad the ad which contains the information which we use to get the score per each typology
	 * @return score
	 */
	private int getScoreByNumberOfWords(String[] words, Ad ad) {
		int score = 0;

		long wordsLength = words.length;


		if (ad.getPlace() instanceof Flat && wordsLength >= 20 && wordsLength <= 49)
			score += 10;
		else if (ad.getPlace() instanceof Flat && wordsLength >50)
			score += 30;
		else if (ad.getPlace() instanceof Chalet && words.length > 50)
			score += 20;
		else 
			score += 5;

		return score;
	}
	
	/**
	 * Calculates the score if the Ad is complete by checking all the rules, described in the requirements.
	 * @param ad the given ad to check
	 * @return boolean
	 */
	private int calculateScoreIfAdIsComplete(Ad ad) {
		return AdService.isComplete(ad) ? 40 : 0;
	}

}
