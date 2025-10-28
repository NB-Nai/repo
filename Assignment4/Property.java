/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: A property class for management company class.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public class Property {
	// Initialize variables for property object.
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;
	
	// Constructor for the property.
	// Empty Constructor
	Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	// Constructor with property object assigned.
	Property(String n, String c, double r, String o) {
		propertyName = n;
		city = c;
		owner = o;
		rentAmount = r;
		plot = new Plot();
	}
	
	// Constructor with property and plot object assigned.
	Property(String n, String c, double r, String o, int x, int y, int w, int d) {
		propertyName = n;
		city = c;
		owner = o;
		rentAmount = r;
		plot = new Plot(x, y, w, d);
	}
	
	// Constructor for copying another property object.
	Property(Property another) {
		propertyName = another.propertyName;
		city = another.city;
		owner = another.owner;
		rentAmount = another.rentAmount;
		plot = new Plot(another.plot);
	}
	
	// Setter & Getter functions for the property.
	public String getPropertyName() {return propertyName;}
	public String getCity() {return city;}
	public double getRentAmount() {return rentAmount;}
	public String getOwner() {return owner;}
	public Plot getPlot() {return plot;}
	
	public void setPropertyName(String value) {propertyName = value;}
	public void setCity(String value) {city = value;}
	public void setRentAmount(double value) {rentAmount = value;}
	public void setOwner(String value) {owner = value;}
	public void setPlot(Plot value) {plot = new Plot(value);}
	
	// Output the information in string format.
	public String toString() {
		return String.format("%s,%s,%s,%s", propertyName, city, owner, rentAmount);
	}
}
