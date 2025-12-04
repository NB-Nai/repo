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

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");
              
                // Use validateInput method
                int choice = 0;
                boolean validInput = false;

                // Retry until valid input is received
                while (!validInput) {
                    try {
                        choice = scanner.nextInt();
                        validInput = true;
                    } catch (CustomInputMismatchException e) {
                        System.out.println(String.format("An error has occured: %s", e)); // Print error message 
                        validInput = false;
                    }
                }
   
                // Run code based on the given choice
                switch (choice) {
                    case 1:
                        handleAddAnimal(circus, scanner);
                        break;
                    case 2:
                        handleAddPerson(circus, scanner);
                        break;
                    case 3:
                        handleAddBuilding(circus, scanner);
                        break;
                    case 4:
                        handleGenerateTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Displaying all animals:");
                        System.out.println("----------------------");
                        circus.displayAllAnimals();
                        break;
                    case 6:
                        System.out.println("Displaying all persons:");
                        System.out.println("----------------------");
                        circus.displayAllPersons();
                        break;
                    case 7:
                        System.out.println("Displaying all buildings:");
                        System.out.println("------------------------");
                        circus.displayAllBuildings();
                        break;
                    case 8:
                        System.out.println("Sorting animals by age...");
                        circus.sortAnimalsByAge();
                        System.out.println("Animals sorted by age.");
                        break;
                    case 9:
                        System.out.println("Sorting animals by name...");
                        circus.sortAnimalsByName();
                        System.out.println("Animals sorted by name.");
                        break;                       
                    case 10:
                        System.out.print("Enter the name of the animal to search: ");
                        scanner.nextLine(); // Consume the leftover newline
                        String searchName = scanner.nextLine();
                        Animal animal = circus.searchAnimalByName(searchName);
                        if (animal != null) {
                        	System.out.println(animal);
                        	animal.move();
                        	animal.makeSound();
                        } else
                        	System.out.println("Animal with given name does not exist.");
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
       
                } catch (Exception e) {
		            System.out.println("An unexpected error occurred: " + e.getMessage());
		            e.printStackTrace();
                } 
            
        }

        scanner.close();
    }

    // Validate the input for choice
    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
	    	try {
	            choice = scanner.nextInt();
	            scanner.nextLine();
	            validInput = true;
	        } catch (InputMismatchException e) {
	            System.out.println(String.format("An error has occured: %s", e));
	            validInput = false;
	            throw new CustomInputMismatchException("Error trying to validate the input from Scanner.");
	        }
        }
        return choice;
    }
    
    // handleAddAnimal()
    private static void handleAddAnimal(Circus circus, Scanner scanner) {
    	Animal animal = null;
    	int choice = 0;
    	String animalType = null;
    	
    	// Information of an animal
    	String name, species, color;
    	int age;
    	boolean choiceSelected = false;
    	
    	while (!choiceSelected) {
    		// Display menu
	    	System.out.println("\nAnimal Type:");
	        System.out.println("1. Add Dog");
	        System.out.println("2. Add Horse");
	        System.out.println("3. Add Bird");
	        System.out.println("4. Add Lion");
	        System.out.println("5. Exit\n");
	        
	        System.out.print("Choose an option: ");
	    	choice = validateInput(scanner);
	        
	        choiceSelected = true;
	        
	        // Pick animal type based on the user choice
	    	switch (choice) {
	    		case 1:
	    			animalType = "Dog";
	    			break;
	    		case 2:
	    			animalType = "Horse";
	    			break;
	    		case 3:
	    			animalType = "Bird";
	    			break;
	    		case 4:
	    			animalType = "Lion";
	    			break;
	    		case 5:
	    			System.out.println("Returning back to the main menu...\n");
	    			return;
	    		default:
	    			System.out.println("Invalid option. Please choose again.");
	    			choiceSelected = false;
	    	}
	    	
	    	if (animalType != null)
	    		System.out.println(String.format("Animal type selected: %s", animalType));
    	}
    	
    	// Let user enter the information about the animal
    	System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Species: ");
        species = scanner.nextLine();
        System.out.print("Enter Color: ");
    	color = scanner.nextLine();
    	
    	System.out.println(String.format("Adding %s to the circus...", animalType.toLowerCase()));
    	
    	// Choice animal type based on the given choice
    	if (animalType.equals("Dog")) 
			animal = new Dog(name, age, species, color);
    	else if (animalType.equals("Horse")) 
			animal = new Horse(name, age, species, color);
    	else if (animalType.equals("Bird")) 
			animal = new Bird(name, age, species, color);
    	else if (animalType.equals("Lion")) 
			animal = new Lion(name, age, species, color);
    	
    	System.out.println(String.format("%s added to the circus.", animalType));
    	
    	circus.addAnimal(animal);
    }
	
    // handleAddPerson()
    private static void handleAddPerson(Circus circus, Scanner scanner) {
    	Person person = null;
    	int choice = 0;
    	String personType = null;
    	
    	// Information of a person
    	String name, job;
    	int age, yearsWorked;
    	boolean choiceSelected = false;
    	
    	while (!choiceSelected) {
    		// Display menu
	    	System.out.println("\nPerson Type:");
	        System.out.println("1. Add Clerk");
	        System.out.println("2. Add Acrobatic");
	        System.out.println("3. Exit\n");
	        
	        System.out.print("Choose an option: ");
	    	choice = validateInput(scanner);
	        
	        choiceSelected = true;
	        
	        // Pick person type based on the user choice
	    	switch (choice) {
	    		case 1:
	    			personType = "Clerk";
	    			break;
	    		case 2:
	    			personType = "Acrobatic";
	    			break;
	    		case 3:
	    			System.out.println("Returning back to the main menu...\n");
	    			return;
	    		default:
	    			System.out.println("Invalid option. Please choose again.");
	    			choiceSelected = false;
	    	}
	    	
	    	if (personType != null)
	    		System.out.println(String.format("Person type selected: %s", personType));
    	}
    	
    	// Let user enter the information about the person
    	System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Work Experience in Years: ");
        yearsWorked = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Job Type: ");
        job = scanner.nextLine();
    	
        System.out.println(String.format("Adding %s to the circus...", personType.toLowerCase()));
    	
        // Person type based on the given choice
    	if (personType.equals("Clerk")) 
			person = new Clerk(name, age, yearsWorked, job);
    	else if (personType.equals("Acrobatic")) 
			person = new Acrobatic(name, age, yearsWorked, job);
    	
    	System.out.println(String.format("%s added to the circus.", personType));
    	
    	circus.addPerson(person);
    }
    
    // handleAddBuilding()
    private static void handleAddBuilding(Circus circus, Scanner scanner) {
    	Building building = null;
    	int choice = 0;
    	String buildingType = null;
    	
    	// Information of a building
    	String color;
    	double length, width;
    	boolean choiceSelected = false;
    	
    	while (!choiceSelected) {
    		// Display menu
	    	System.out.println("\nBuilding Type:");
	        System.out.println("1. Add Arena");
	        System.out.println("2. Add Ticketing Office");
	        System.out.println("3. Exit\n");
	        
	        System.out.print("Choose an option: ");
	    	choice = validateInput(scanner);
	        
	        choiceSelected = true;
	        
	        // Pick building type based on the user choice
	    	switch (choice) {
	    		case 1:
	    			buildingType = "Arena";
	    			break;
	    		case 2:
	    			buildingType = "Ticketing Office";
	    			break;
	    		case 3:
	    			System.out.println("Returning back to the main menu...\n");
	    			return;
	    		default:
	    			System.out.println("Invalid option. Please choose again.");
	    			choiceSelected = false;
	    	}
	    	
	    	if (buildingType != null)
	    		System.out.println(String.format("Person type selected: %s", buildingType));
    	}
    	
    	// Let user enter information about the building
    	System.out.print("Enter Color: ");
        color = scanner.nextLine();
        System.out.print("Enter Length: ");
        length = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Width: ");
        width = scanner.nextDouble();
        scanner.nextLine();
    	
        System.out.println(String.format("Adding %s to the circus...", buildingType.toLowerCase()));
    	
        // Building type based on the given choice
    	if (buildingType.equals("Arena")) 
			building = new Arena(color, length, width);
    	else if (buildingType.equals("Ticketing Office")) 
			building = new TicketingOffice(color, length, width);
    	
    	System.out.println(String.format("%s added to the circus.", buildingType));
    	
    	circus.addBuilding(building);
    }



    private static void handleGenerateTicket(Scanner scanner) {
        double totalAmount = 0;
        double basePrice;
        StringBuilder ticketDetails = new StringBuilder();
        boolean addMoreTickets = true;

        System.out.print("\nEnter ticket base price: ");
        basePrice = scanner.nextDouble();
        scanner.nextLine();

        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        while (addMoreTickets) {
            // Select day of the week
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek day = DayOfWeek.values()[i];
                if (day.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, day);
                }
            }
            System.out.print("\nEnter your choice: ");
            int dayChoice = scanner.nextInt();
            scanner.nextLine();

            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
                System.out.println("Invalid choice. Please select a valid day.");
                continue;
            }

            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Select customer type
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            System.out.print("\nEnter your choice: ");
            int customerType = scanner.nextInt();
            scanner.nextLine();

            double customerDiscount = 0.0;
            String customerTypeName = "";
            switch (customerType) {
                case 1:
                    customerDiscount = 0.10;
                    customerTypeName = "child";
                    break;
                case 2:
                    customerDiscount = 0.10;
                    customerTypeName = "student";
                    break;
                case 3:
                    customerTypeName = "adult";
                    break;
                case 4:
                    customerDiscount = 0.05;
                    customerTypeName = "senior";
                    break;
                default:
                    System.out.println("Invalid customer type. Please try again.");
                    continue;
            }

            // Select seat location
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            System.out.print("\nEnter your choice: ");
            int seatLocation = scanner.nextInt();
            scanner.nextLine();

            double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

            System.out.print("Enter number of tickets: ");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine();

            // Calculate discounts and total price for this batch of tickets
            double discount = dayDiscount + customerDiscount + seatDiscount;
            double totalPrice = basePrice * numberOfTickets * seatMultiplier * discount;

            // Add to total amount
            totalAmount += totalPrice;

            // Append details of this batch to the ticket details
            String ticketInfo = String.format("%s %s $%.2f (Day: %s, Day Discount: %d%%, Customer Type Discount: %d%%)\n",
            									numberOfTickets, customerTypeName, totalPrice, selectedDay, 
            									Math.round(dayDiscount*100), Math.round(customerDiscount*100));
            ticketDetails.append(ticketInfo);
            
            // Append details of this batch to the ticket details
            

            // Ask user to add more tickets
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreTickets = response.equals("y");
        }

        // Display ticket calculation details
        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails);

        // Display final total amount
        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }


   
}
