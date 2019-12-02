package com.test.adstracking.util;

/**
 * Util class for text's handling
 * @author Mohamed El Boutahiri
 *
 */
public class TextUtils {

	/**
	 * The regular expression which allows us to look for words in a given text
	 */
	private static final String REGEX_SPLIT_WORDS = "[^A-Za-záéíóú]+";

	/**
	 * Applies the regular expression defined "REGEX_SPLIT_WORDS" to split a string in words.
	 * @param text the given text to split
	 * @return words the array of words splitted
	 */
	public static String[] getWordsFromText(String text) {

		String[] words = text.split(REGEX_SPLIT_WORDS);

		return words;

	}

}
