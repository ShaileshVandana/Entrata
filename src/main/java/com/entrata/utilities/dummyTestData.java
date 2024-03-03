package com.entrata.utilities;
import org.apache.commons.lang3.RandomStringUtils;

public class dummyTestData {
	
	public static String createTestEmailAddress(int i) {
		String emailID = RandomStringUtils.randomAlphanumeric(i) + "@gmail.com";
        return emailID;
	}
	
	public static String createTestMobileNumber(int i) {
		String MobileNumber = RandomStringUtils.randomNumeric(i);
        return MobileNumber; 
	}
	
	public static String createTestName(int i) {
		String name = RandomStringUtils.randomAlphabetic(i);
	    return name;
	}

}
