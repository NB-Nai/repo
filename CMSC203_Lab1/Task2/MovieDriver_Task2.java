/**
	Class: CMSC203 CRN 23118 
	Program: Lab 1 
	Instructor: Huseyin Aygun 
	Summary of Description: Allow user to provide the movie title, rating, and the amount of ticket sold, and format them into a line. 
	Due Date: 9/29/2025 
	Integrity Pledge: I pledge that I have completed the programming assignment independently. 
	I have not copied the code from a student or any source. 
	Student Name: Natdanai Boonyaleephan
*/

package Task2;
import java.util.Scanner;

public class MovieDriver_Task2 {
	public static void main(String[] args) {
		// Create scanner to receive input and movie object.
		Scanner keyboard = new Scanner(System.in);
		Movie movie = new Movie();
		// A variable char to store user input to determine the loop.
		char keepLooping;
		
		// A do-while loop.
		do {
			// Output the message and ask user for input.
			System.out.println("Enter the name of a movie");
			// Ask user to enter "Movie Title" for the movie object.
			movie.setTitle(keyboard.nextLine());
			System.out.println("Enter the rating of the movie");
			// Ask user to enter "Movie Rating" for the movie object.
			movie.setRating(keyboard.nextLine());
			System.out.println("Enter the number of tickets sold for this movie");
			// Ask user to enter "Amount of ticket sold" for the movie object.
			movie.setSoldTickets(keyboard.nextInt());
			// Output movie object into a formatted string.
			System.out.println(movie.toString());
			System.out.println("Do you want to enter another? (y or n)");
			// Get char from user input for determining loop.
			keepLooping = keyboard.next().charAt(0);
			// Skip nextLine so that it does not skip the next scanner nextLine.
			keyboard.nextLine();
		} while (keepLooping == 'y');
		// Loop while user enter char 'y'.
		
		// Say goodbye to the user and close the scanner object.
		System.out.println("Goodbye");
		keyboard.close();
	}
}
