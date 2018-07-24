package arrayLab;

//This program was created by Brian Seyferth on 7/24/18

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {
		
		//Opens the Scanner and Declares all the needed variables
		Scanner scnr = new Scanner(System.in);
		String[] people = {"Brian", "Anne", "Elise", "Sadie", "Kim", "David", "Tim", "Mark"};
		String[] homeTown = {"Chelsea", "Ann Arbor", "Chattanooga", "Grosse Ile", "Taylor", "Detroit", "Mackinaw", "Allen Park"};
		String[] food = {"Pizza", "Bread Sticks", "Alfredo", "Blueberries", "Grilled Cheese", "Perogis", "Steak", "Tacos"};
		int userInputNum = 0;
		int indexNumber = 0;
		char restartApp = 'y';
		String moreInfo ="yes";
		boolean intCheck = true;
		String userResponse = "";
		
		//prints out a welcome to the program
		System.out.println("Welcome to our Java Class!");
		
		//initial do loop sets up a restart option for program
		do {
			
			//shows the name options and the number they represent
			for (int i = 0; i < people.length; i++) {
				System.out.println( (i+1) + ". " + people[i]);	
				}
			
			//this do while loop is used to validate that a user gets a valid integer
			do {
				
				//this try catch catches the possible errors from picking a number
				try {
					System.out.println("Which student would you like to learn more about? (1-8)");
					userInputNum = scnr.nextInt();
					userResponse =scnr.nextLine();
					indexNumber = userInputNum - 1;
					System.out.print("Student " + userInputNum + " is " + people[indexNumber] + ". "); 
					intCheck = true;
					
					// this do while loop sets up the more info option for the user on each name.
					do {
						System.out.println("What would you like to know about " + people[indexNumber] + "? (enter \"hometown\" or \"favorite food\")");
						userResponse = scnr.nextLine();
					
					// if, else if, and else statement to look at answer from user about type of info
					// then prints out the corresponding responses
					if (userResponse.equalsIgnoreCase("hometown")) {
						System.out.println(people[indexNumber] + " is from " + homeTown[indexNumber] + ". Would you like to know more? (enter \"yes\" or \"no\")");
						moreInfo = scnr.nextLine();
					} else if (userResponse.equalsIgnoreCase("favorite food")) {
						System.out.println(people[indexNumber] + "'s favorite food is " + food[indexNumber] + ". Would you like to know more? (enter \"yes\" or \"no\")");
						moreInfo = scnr.nextLine();
					} else {
						System.out.println("That data does not exist. Please try again. (enter \"hometown\" or \"favorite food\")");
						moreInfo = "yes";
					}
					} while(moreInfo.equals("yes"));
				
				// this is the continued catch for errors regarding valid integer inputs	
				} catch (InputMismatchException ex1) {
					System.out.println("You did not input a number. Please try again.");
					intCheck = false;
				} catch (ArrayIndexOutOfBoundsException ex2) {
					System.out.println("Your number was not in the range. Please try again.");
					intCheck = false;
				}
			} while (intCheck == false);
	
			//asks the restart question and collects response
			System.out.println("Would you like to start the program over? (y to continue)");
				restartApp = scnr.next().charAt(0);
		} while(restartApp == 'y' || restartApp =='Y');
		
		//prints out a leaving message when program is over
		System.out.println("Goodbye!");
		
		scnr.close();
	}

}
