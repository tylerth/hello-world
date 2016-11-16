import java.util.Scanner;


public class PasswordChecker {

	public static void main(String[] args) {
		
		// set up a Scanner to read user input
		Scanner keyboard = new Scanner(System.in);
		
		// getting their password
		System.out.println("Please enter your password.");
		String password = keyboard.nextLine();
		
		// getting their name
		System.out.println("Please enter your first name.");
		String firstName = keyboard.nextLine();
		
		// while their password is invalid, keep prompting them for a password
		while (passwordValid(password, firstName) == false) {
			System.out.println("Please enter a valid password.");
			password = keyboard.next();
		}

		// ends the program when password is valid
		System.out.println("Password is valid. Closing.");
		keyboard.close();
			
	}
	
////////////// METHODS //////////////	
	
	// method that checks password validity, used for the while loop
	public static boolean passwordValid(String password, String name) {
		
		if (checkLength(password) == false
				|| checkForName(password, name) == false
				|| checkForUppercase(password) == false
				|| checkForLowercase(password) == false
				|| checkForNumber(password) == false ) {
			
			return false;
		}
		
		return true;
	}
	
	// checks to make sure password is greater than 8 characters
	public static boolean checkLength(String password) {
		
		if (password.length() >= 8 ) {
			return true;
		} else {
			System.out.println("Your password is less than 8 characters.");
		}
		
		return false;
	}
	
	// checks to make sure password does not contain user's first name
	public static boolean checkForName(String password, String name) {
	
		// checks to see if the password does NOT contain the name
		// will then return true
		if (!password.contains(name)) {
			return true;
		} else {
			System.out.println("Your name is in the password.");
		}
		
		return false;
	}

	// checks to make sure password contains at least 1 upper case letter
	public static boolean checkForUppercase(String password) {
	/**	
		// checks if the password given is equal to the password made lowercase
		// if they are unequal, then it contains an uppercase letter
		boolean hasUppercase = !password.equals(password.toLowerCase());
		
		if (hasUppercase) {
			return true;
		} else {
			System.out.println("Your password does not contain an uppercase letter.");
		}
		**/
		
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
				return true;
			}
		}
			
		System.out.println("Your password does not contain an uppercase letter.");
		return false;
	}
	
	// checks to make sure password contains at least 1 lower case letter
	public static boolean checkForLowercase(String password) {
		
		// checks if the password given is equal to the password made uppercase
		// if they are unequal, then it contains a lowercase letter
		boolean hasLowercase = !password.equals(password.toUpperCase());
		
		if (hasLowercase) {
			return true;
		} else {
			System.out.println("Your password does not contain a lowercase letter.");
		}
		
		return false;
	}
	
	// checks to make sure password contains a number
	public static boolean checkForNumber(String password) {
		
		// for loop to loop through string
		for (int i = 0; i < password.length(); i++) {
			// checks if the character at position 'i' in the string is a digit
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		
		System.out.println("Your password does not contain a number.");
		return false;
	}
	
// end of program	
}
