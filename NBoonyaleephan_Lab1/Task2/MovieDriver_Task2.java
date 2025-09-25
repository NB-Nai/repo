import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Movie movie = new Movie();
		char keepLooping;
		
		do {
			System.out.println("Enter the name of a movie");
			movie.setTitle(keyboard.nextLine());
			System.out.println("Enter the rating of the movie");
			movie.setRating(keyboard.nextLine());
			System.out.println("Enter the number of tickets sold for this movie");
			movie.setSoldTickets(keyboard.nextInt());
			System.out.println(movie.toString());
			System.out.println("Do you want to enter another? (y or n)");
			keepLooping = keyboard.next().charAt(0);
			keyboard.nextLine();
		} while (keepLooping == 'y');
		
		System.out.println("Goodbye");
		keyboard.close();
	}
}
