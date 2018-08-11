package utilities;

import org.apache.commons.lang.RandomStringUtils;

public class RandomFunctions {
	public static String randomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public static String randomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	
	public static String randomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	public static String randomAllowedChars(int length, String allowedChar) {
		//String allowedChars="abcdefghijkl"+"12345";
		return RandomStringUtils.random(length, allowedChar);
	}
	
	public static String randomEmail(int length) {
		String allowedChars="abcdefghijklmnopqrstuvwxyz"+"1234567890";
		String email="";
		String temp=RandomStringUtils.random(length, allowedChars);
		email=temp.substring(0, temp.length()-3)+"@test.org";
		return email;
	}
	
	public static String randomUrl(int length) {
		String allowedChars="abcdefghijklmnopqrstuvwxyz"+"1234567890";
		String url="";
		String temp=RandomStringUtils.random(length, allowedChars);
		url=temp.substring(0, 3)+"."+temp.substring(4, temp.length()-3)+"."+temp.substring(temp.length()-2);
		return url;
	}
	
}
