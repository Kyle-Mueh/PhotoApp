package LTPhotoApp;

import java.util.Scanner;

/**
 * Prompts and accepts user's input
 * 
 * @author Kyle Muehlenthaler
 *
 */
public class UserIO {
	public String promptForInput() {
		
		//Prompts for user input
		System.out.print("Please enter the album you would like to query: ");
		
		//Accepts input, not validated input

		Scanner in = new Scanner(System.in);
		String input=in.nextLine();

		//returns the user's input
		return input;
	}
}
	
