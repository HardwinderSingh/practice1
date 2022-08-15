package dev1.operations;

import java.util.Random;

public class OperationClass {

	public static String genrateOtp(String mobile) {
		if (mobile.length() == 10) {
			StringBuffer sBuffer = new StringBuffer();
			for (int i = 0; i <= 9; i++) {
				sBuffer.append(new Random().nextInt(9));

			}
			
			return sBuffer.substring(5);
		} else
			return "invalid mobile";
	}
}
