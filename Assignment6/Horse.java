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

import java.util.Objects;

public class Horse implements Animal, Cloneable {
	
	//instance variables
	private String name;
    private int age;
    private String species;
    private String color;
    
    //constructor
    public Horse(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
    // Move the animal.
	public void move() {
		System.out.println(String.format("%s has moved to different spot.", name));
	}

	@Override
	// Cause the animal to make sound.
	public void makeSound() {
		System.out.println(String.format("%s has made a Horse noise.", name));
	}

	@Override
	// Return the animal's name.
	public String getName() {
		return name;
	}

	@Override
	// Return the animal's age.
	public int getAge() {
		return age;
	}
	
	// Comparing between this and other object.
	public boolean equals(Horse obj) {
		// Check for reference equality
    	if (obj == this)
    		return true;
    	// Check for null or different class
    	else if (Objects.isNull(obj) || !obj.getClass().equals(this.getClass()))
    		return false;
    	else {
    		// Compare fields for logical equality	
    		if (obj.name.equals(name) &&
				obj.age == age &&
				obj.species.equals(species) &&
				obj.color.equals(color))
    			return true;
    		else
    			return false;
    	}
    }

	@Override
	// Return the clone of this instance.
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();	
	}
	
    @Override
    // Return information a formated string.
	public String toString() {
    	return String.format("Name: %s\nAge: %s\nSpecies: %s\nColor: %s", name, age, species, color);
    }
 
}
