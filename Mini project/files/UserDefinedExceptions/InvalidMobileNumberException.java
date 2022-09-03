package UserDefinedExceptions;

public class InvalidMobileNumberException extends Exception {
	public static boolean checkValidMobileNumber(String s) {
		try {
			Long.parseLong(s);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return s.length() == 10;
	}
}	
