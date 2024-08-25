package com.bankingapplication.utility;

import java.util.Random;

public class IdGenerator {
	
	private static final Random random = new Random();
	
	
	public static Long generate12DigitId() {
		long leftLimit = 100_000_000_000L;
		long rightLimit = 900_900_900_900L;
		
		
		return leftLimit + (long) (random.nextDouble()*(rightLimit -leftLimit));
		
		
			
	}

}
