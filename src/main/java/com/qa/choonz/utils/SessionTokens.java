package com.qa.choonz.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SessionTokens {

	/**
	 * Each token produced by this class uses this identifier as a prefix.
	 */
	public static final String ID = "$31$";

	/**
	 * The minimum recommended cost, used by default
	 */
	public static final int DEFAULT_COST = 11;

	private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

	private static final int SIZE = 128;

	private static final Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");

	private final SecureRandom random;

	private final int cost;

	public SessionTokens() {
		this(DEFAULT_COST);
	}

	/**
	 * Create a password manager with a specified cost
	 * 
	 * @param cost the exponential computational cost of hashing a password, 0 to 30
	 */
	public SessionTokens(int cost) {
		iterations(cost); /* Validate cost */
		this.cost = cost;
		this.random = new SecureRandom();
	}

	private static int iterations(int cost) {
		if ((cost < 0) || (cost > 30))
			throw new IllegalArgumentException("cost: " + cost);
		return 1 << cost;
	}

	public String newSessionToken() {
		byte[] salt = new byte[SIZE / 8];
		random.nextBytes(salt);
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        char[] tokenChar = randomUUIDString.toCharArray();
		byte[] dk = pbkdf2(tokenChar, salt, 1 << cost);
		byte[] hash = new byte[salt.length + dk.length];
		System.arraycopy(salt, 0, hash, 0, salt.length);
		System.arraycopy(dk, 0, hash, salt.length, dk.length);
		Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
		return ID + cost + '$' + enc.encodeToString(hash);
	}

	private static byte[] pbkdf2(char[] token, byte[] salt, int iterations) {
		KeySpec spec = new PBEKeySpec(token, salt, iterations, SIZE);
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
			return f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
		} catch (InvalidKeySpecException ex) {
			throw new IllegalStateException("Invalid SecretKeyFactory", ex);
		}
	}

}
