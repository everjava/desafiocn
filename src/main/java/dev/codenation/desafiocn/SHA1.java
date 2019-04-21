package dev.codenation.desafiocn;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

	
	
	public static String encryptSHA1Hex(String sentence) throws NoSuchAlgorithmException, UnsupportedEncodingException {

	    MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	    crypt.reset();
	    crypt.update(sentence.getBytes("UTF-8"));

	    return new BigInteger(1, crypt.digest()).toString(16);
	}
	
	
}
