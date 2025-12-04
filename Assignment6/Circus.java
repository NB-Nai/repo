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

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    // Add building
    public void addBuilding(Building building) {
    	buildings.add(building);
    }
    
    // Get buildings
    public List<Building> getBuildings() {
    	List<Building> copy = new ArrayList<>();
    	for (int i=0; i<buildings.size(); i++) {
    		copy.add(buildings.get(i));
    	}
    	return copy;
    }

    // Display building
    public void displayAllBuildings() {
    	for (int i=0; i<buildings.size(); i++) {
    		System.out.println(String.format("\nBuilding #%s: \n%s", i+1, buildings.get(i).toString()));
    	}
    }
    
    // Add person
    public void addPerson(Person person) {
    	persons.add(person);
    }
    
    // Get persons
    public List<Person> getPersons() {
    	List<Person> copy = new ArrayList<>();
    	for (int i=0; i<persons.size(); i++) {
    		copy.add(persons.get(i));
    	}
    	return copy;
    }

    // Display person
    public void displayAllPersons() {
    	for (int i=0; i<persons.size(); i++) {
    		System.out.println(String.format("\nPerson #%s: \n%s", i+1, persons.get(i).toString()));
    	}
    }

    // Add animal
    public void addAnimal(Animal animal) {
    	animals.add(animal);
    }
    
    // Get animals
    public List<Animal> getAnimals() {
    	List<Animal> copy = new ArrayList<>();
    	for (int i=0; i<animals.size(); i++) {
    		copy.add(animals.get(i));
    	}
    	return copy;
    }
    
    // Display animal using toString() method
    public void displayAllAnimals() {
    	for (int i=0; i<animals.size(); i++) {
    		System.out.println(String.format("\nAnimal #%s: \n%s", i+1, animals.get(i).toString()));
    	}
    }
    
    // Selection sort to sort animals by age
    public void sortAnimalsByAge() {
    	int minIndex;
    	Animal minValue;
    	
    	for (int startScan = 0; startScan < (animals.size()-1); startScan++) {
    		minIndex = startScan;
    		minValue = animals.get(startScan);
    		for (int index = startScan+1; index < animals.size(); index++) {
    			if (animals.get(index).getAge() < minValue.getAge()) {
    				minValue = animals.get(index);
    				minIndex = index;
    			}
    		}
    		animals.set(minIndex, animals.get(startScan));
    		animals.set(startScan, minValue);
    	}
    }
    
    // Selection sort to sort animals by name
    public void sortAnimalsByName() {
    	int minIndex;
    	Animal minValue;
    	
    	for (int startScan = 0; startScan < (animals.size()-1); startScan++) {
    		minIndex = startScan;
    		minValue = animals.get(startScan);
    		for (int index = startScan+1; index < animals.size(); index++) {
    			if (animals.get(index).getName().compareTo(minValue.getName()) < 0) {
    				minValue = animals.get(index);
    				minIndex = index;
    			}
    		}
    		animals.set(minIndex, animals.get(startScan));
    		animals.set(startScan, minValue);
    	}
    }
    
    // Search for an animal by name
    public Animal searchAnimalByName(String name) throws CloneNotSupportedException {
    	for (int i=0; i<animals.size(); i++) {
    		Animal animal = animals.get(i);
    		
    		// Return the cloned object 
    		if (animal.getName().equals(name))
        		if (animal.getClass().equals(Bird.class)) {
        			Bird bird = (Bird) animal;
        			return (Bird) bird.clone();
        		} else if (animal.getClass().equals(Dog.class)) {
        			Dog dog = (Dog) animal;
        			return (Dog) dog.clone();
        		} else if (animal.getClass().equals(Horse.class)) {
        			Horse horse = (Horse) animal;
        			return (Horse) horse.clone();
        		} else if (animal.getClass().equals(Lion.class)) {
        			Lion lion = (Lion) animal;
        			return (Lion) lion.clone();
        		}
    	}
    	return null;
    }
    
    // Add ticket
    public void addTicket(Ticket ticket) {
    	tickets.add(ticket);
    }

    // Generate ticket
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        Ticket ticket = new Ticket(dayOfWeek, basePrice, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
        addTicket(ticket);
        return ticket;
    }
}
