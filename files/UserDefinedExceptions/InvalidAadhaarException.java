package UserDefinedExceptions;

public class InvalidAadhaarException extends Exception {
	public static boolean checkValidAadhaar(String s) {
		try {
			Long.parseLong(s);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return s.length() == 12;
	}
}	