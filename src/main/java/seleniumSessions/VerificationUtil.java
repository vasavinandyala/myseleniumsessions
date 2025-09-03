package seleniumSessions;

public class VerificationUtil {
	
	public static boolean verify(String actualValue, String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			System.out.println("actual value " + actualValue + "is equal to expected value" + expectedValue);
			return true;
		}
		return false;
	}
	
	public static boolean verifyEquals(int actualValue, int expectedValue) {
		if(actualValue == expectedValue) {
			System.out.println("actual value " + actualValue + "is equal to expected value" + expectedValue);
			return true;
		}
		else {
			System.out.println("actual value " + actualValue + "is not equal to expected value" + expectedValue);
			return false;
		}
	}
	
	public static boolean verifyContains(String actualValue, String fractionValue) {
		if(actualValue.contains(fractionValue)) {
			System.out.println("actual value " + actualValue + "is present in fraction value" + fractionValue);
			return true;
		}
		
		return false;

	}

}
