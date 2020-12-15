package com.app.camel.util;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateVehicalId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder builder = new StringBuilder(length);
		
		for(int i = 0; i < length; i++) {
			builder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(builder);
	}
}
