package dev.codenation.desafiocn;

import java.util.Arrays;

public class Caesar {

	private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final int ALPHABET_SIZE = ALPHABET.length;

	/**
	 * 
	 * @param sentence
	 * @param shift
	 * @return
	 */
	public static String encrypt(String sentence, int shift) {

		StringBuilder sb = new StringBuilder(sentence.length());
		for (char c : sentence.toCharArray())
			sb.append(encryptChar(c, shift));

		return sb.toString();
	}

	/**
	 * 
	 * @param sentence
	 * @param shift
	 * @return
	 */
	public static String decrypt(String sentence, int shift) {
		shift = ALPHABET_SIZE - shift;
		StringBuilder sb = new StringBuilder(sentence.length());
		for (char c : sentence.toCharArray())
			sb.append(encryptChar(c, shift));
		return sb.toString();
	}

	
	/**
	 * 
	 * @param curChar
	 * @param shift
	 * @return
	 */
	public static char encryptChar(char curChar, int shift) {

		int charPosition = Arrays.binarySearch(ALPHABET, Character.toUpperCase(curChar));//UPPERCASE?

		if (charPosition < 0)
			return curChar;

		int newCharPosition = (charPosition + shift) % 26;
		char shiftedChar = ALPHABET[newCharPosition];
		
		return Character.toLowerCase(shiftedChar);
	}

}
