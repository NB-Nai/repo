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

public class TicketingOffice implements Building {
	//instance variables
    private String color;
    private double length;
    private double width;
    private String buildingType;

    //constructor
    public TicketingOffice(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Ticketing Office";
    }

    @Override
	// Set arena size to the given length and width.
	public void setSize(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	// Return the length of the ticketing office.
	public double getLength() {
		return length;
	}

	@Override
	// Return the width of the ticketing office.
	public double getWidth() {
		return width;
	}

	@Override
	// Set the ticketing office color to the given color.
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	// Return the color of the ticketing office.
	public String getColor() {
		return color;
	}

	@Override
	// Set the building type of the ticketing office to the given type.
	public void setBuildingType(String type) {
		this.buildingType = type;
	}

	@Override
	// Return the building type of the ticketing office.
	public String getBuildingType() {
		return buildingType;
	}

    @Override
    // Return information in a formated string.
	public String toString() {
    	return String.format("Color: %s\nLength: %s\nWidth: %s\nBuilding: %s", color, length, width, buildingType);
    }

}
