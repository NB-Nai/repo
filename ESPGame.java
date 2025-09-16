/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: This give you 4 options to show colors and play a color minigame and repeat if user want to do so.
 * Due: 9/15/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/


// Import required functions
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ESPGame {
	public static void main(String[] args) {	
		// Try block to handle exception for when file is not found.
		try {
			// Set up constant String variable for fileName
			final String COLOR_FILE_NAME = "colors.txt";
			final String GAME_RESULT_FILE_NAME = "EspGameResults.txt";
			
			// Get file in the directory and create scanner out of user input.
			File colorFile = new File(COLOR_FILE_NAME);
			Scanner keyboard = new Scanner(System.in);
			Random random = new Random();
			
			boolean repeat = true;
			int correctGuesses = 0;
			do {
				// Display message for user to select from the menu.
				System.out.println("\nCMSC203 Assignment1: Test your ESP skills!\n"
						+ "Welcome to ESP - extrasensory perception!\n"
						+ "Would you please choose one of the 4 options from the menu:\n\n"
						+ "   1- Read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
						+ "   2- Read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
						+ "	  3- Read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.\n"
						+ "	  4- Exit from a program.\n"
				);
				int colorsToRead = 0;
				// Do things based on user choice; either set colors amount to read or exit from program.
				switch (keyboard.nextInt()) {
					case 1: colorsToRead = 16;
							break;
					case 2: colorsToRead = 10;
							break;
					case 3: colorsToRead = 5;
							break;
					case 4: repeat = false;
							break;
				}
				keyboard.nextLine();
				
				// Check if the user exit the program or not and also initialize correctGuesses for at the end of program.
				if (repeat) {
					// Open the file to read and print out the amount of colors from previous option.
					Scanner inputFile = new Scanner(colorFile);
					for (int i=1; i<=colorsToRead; i++) {
						String color = inputFile.next();
						System.out.println(i + " " + color);
					}
					System.out.println();
					// Close the program so it reset the reader position for next open.
					inputFile.close();
					
					// Set correctGuesses variable back to zero to get the latest score from user.
					correctGuesses = 0;
					// Play a color minigame with user for 3 rounds.
					for (int round=1; round<=3; round++) {
						// Print out messages and get color name from user input for later use.
						System.out.printf("Round %d\n\n", round);
						System.out.print("I am thinking of a color.\n"
								+ "Is it one of list of colors above?\n"
								+ "Enter your guess: "
						);
						// Turn all to lower cases for comparison.
						String colorInput = keyboard.next().toLowerCase();
						keyboard.nextLine();
						
						// Open file yet again for read and randomize out of 16 colors.
						Scanner inputFile2 = new Scanner(colorFile);
						for (int i=1; i<random.nextInt(16); i++) {
							inputFile2.next();
						}
						// Get the randomized color from file.
						String randomColor = inputFile2.next();
						// Close the file since we don't need it anymore.
						inputFile2.close();
						
						// Increment correctGuesses by 1 if the user guess the color correctly.
						if (colorInput.matches(randomColor.toLowerCase())) 
							correctGuesses++;
						// Print out the color from randomization.
						System.out.println("\nI was thinking of " + randomColor + ".");
					}
					// Show how much user guessed correctly after finishing all 3 rounds.
					System.out.printf("Game Over\n\n" + 
							"You guessed %d out of 3 colors correctly.\n", correctGuesses);
					System.out.println("\nWould you like to continue a Game? Type Yes/No");

					if (keyboard.next().toLowerCase().matches("yes"))
						repeat = true;
					else
						repeat = false;
					keyboard.nextLine();
				}
			} while (repeat);
			
			// Get information from user and compose them into a new file called 'EspGameResults.txt'
			System.out.print("\nEnter your name: ");
			String fullName = keyboard.nextLine();
			System.out.print("Describe yourself: ");
			String description = keyboard.nextLine();
			System.out.print("Due Date: ");
			String dueDate = keyboard.nextLine();
			System.out.printf("Username: %s\n"
					+ "User Description: %s\n"
					+ "Date: %s", fullName, description, dueDate);
			
			// Create file and write all the information in the given format into the file.
			PrintWriter outputFile = new PrintWriter(GAME_RESULT_FILE_NAME);
			outputFile.printf("Game Over\n"
					+ "You guessed %d out of 3 colors correctly.\n"
					+ "Due Date: %s\n"
					+ "Username: %s\n"
					+ "User Description: %s\n"
					+ "Date: %s\n", correctGuesses, dueDate, fullName, description, dueDate);
			// The date here is confusing since we have not been taught about getting user's current date and the word document show that the date and the due date are exactly the same so I assumed it to be another due date.
			
			// Close the file after finished writing all the information.
			outputFile.close();
			
			// Close user input scanner when done.
			keyboard.close();
		} catch (FileNotFoundException e) {
			// Throw error when the program can't find the file.
			e.printStackTrace();
		}
	}
}
