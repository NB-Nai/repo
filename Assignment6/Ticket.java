/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: Allow for managing different parts of the circus such as animals, buildings, people, and ticket sales, and calculate the cost of ticket based on their preference.
 * Due: 12/08/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }

    // Calculate ticket price based on day of week and age
        // Apply discounts for weekdays
        // Apply age-based discounts
    public double calculatePrice() {
    	double finalPrice = basePrice;
    	
    	// Discount on weekday
    	if (dayOfWeek.contains("monday") || 
    		dayOfWeek.contains("tuesday") || 
    		dayOfWeek.contains("wednesday") ||
    		dayOfWeek.contains("thursday") ||
    		dayOfWeek.contains("friday"))
    		finalPrice *= 0.90;
    	
    	// Child & Student age range
    	if (age < 12)
    		finalPrice *= 0.90;
    	// Senior age range
    	else if (age >= 60)
    		finalPrice *= 0.95;
    	
    	return finalPrice;
    }

    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}
