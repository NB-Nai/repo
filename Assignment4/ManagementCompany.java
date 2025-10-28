/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: Allow user to create management company and show list of added properties. Also allow for other various features related to management company as well. 
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public class ManagementCompany {
	// Initialize default value for management company object for size and max properties.
	public final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	// Initialize variables for management company object.
	private String name, taxId;
	private double mgmtFeePercent;
	private int numberOfProperties;
	private Plot plot;
	private Property[] properties = new Property[MAX_PROPERTY];
	
	// Constructor for the management company.
	// Empty Constructor
	ManagementCompany() {
		name = "";
		taxId = "";
		mgmtFeePercent = 0;
		numberOfProperties = 0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	// Constructor with management company object assigned.
	ManagementCompany(String n, String tl, double mF) {
		name = n;
		taxId = tl;
		mgmtFeePercent = mF;
		numberOfProperties = 0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	// Constructor with management company and plot object assigned.
	ManagementCompany(String n, String tl, double mF, int x, int y, int w, int d) {
		name = n;
		taxId = tl;
		mgmtFeePercent = mF;
		numberOfProperties = 0;
		plot = new Plot(x, y, w, d);
	}
	
	// Constructor for copying another management company object.
	ManagementCompany(ManagementCompany another) {
		name = another.name;
		taxId = another.taxId;
		mgmtFeePercent = another.mgmtFeePercent;
		numberOfProperties = 0;
		plot = new Plot(another.plot);
	}
	
	// Getter functions for the management company.
	public String getName() {return name;}
	public String getTaxId() {return taxId;}
	public double getMgmtFeePercent() {return mgmtFeePercent;}
	public Plot getPlot() {return plot;}
	
	// The base function for addProperty method, which take property object.
	public int addProperty(Property p) {
		// If property doesn't exist (equal to null) then return error code -2.
		if (p == null)
			return -2;
		// If the amount of property in properties array exceed the maximum amount of property that can be in properties array, then return error code -1.
		if (numberOfProperties >= MAX_PROPERTY)
			return -1;
		// If the property is outside of the management company area, then return error code -3.
		if (plot.encompasses(p.getPlot()) == false)
			return -3;

		// Check if the property overlaps on any existing property in properties array, if overlapped then return error code -4.
		for (Property q : properties) {
			if (q != null && p.getPlot().overlaps(q.getPlot()) == true)
				return -4;
		}
		
		// Add property to the properties array.
		properties[numberOfProperties] = p;
		// Return the amount of property inside properties array before the given property was added.
		return numberOfProperties++;
	}
	
	// Create and assign property object, then call base method.
	public int addProperty(String n, String c, int r, String o) {
		return addProperty(new Property(n, c, r, o));
	}
	
	// Create and assign property and plot object, then call base method.
	public int addProperty(String n, String c, int r, String o, int x, int y, int w, int d) {
		return addProperty(new Property(n, c, r, o, x, y, w, d));
	}
	
	// Get total rent of the rent amount in all property in properties array.
	public double getTotalRent() {
		double total = 0;
		for (int i=0; i<numberOfProperties; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	// Return the property with highest rent amount, return null if the array is emptied otherwise.
	public Property getHighestRentProperty() {
		if (numberOfProperties == 0)
			return null;
		
		Property max = properties[0];
		
		// Assign max the property from the index i of properties array if the rent amount is higher than the one in variable max property.
		for (int i=1; i<numberOfProperties-1; i++) {
			if (properties[i].getRentAmount() > max.getRentAmount())
				max = properties[i];
		}
		
		return max;
	}
	
	// Remove the latest property from the properties array.
	public void removeLastProperty() {
		if (numberOfProperties > 0)
			properties[--numberOfProperties] = null;
	}
	
	// Check if the properties array exceed the default value of MAX_PROPERTY.
	public boolean isPropertiesFull() {
		return (numberOfProperties > MAX_PROPERTY);
	}
	
	// Return the amount of property in properties array.
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	// Check if the given fee for the management company object is valid.
	public boolean isManagementFeeValid() {
		return (mgmtFeePercent >= 0 && mgmtFeePercent <= 100);
	}
	
	// Output the information in string format.
	public String toString() {
		// Propertylist variable contain the information of all property in properties array in list.
		String propertyList = "";
		for (int i=0; i<numberOfProperties; i++) {
			propertyList += properties[i].toString() + '\n';
		}
		return String.format("List of the properties for %s, taxID: %s\n"
				+ "______________________________________________________\n"
				+ "%s"
				+ "______________________________________________________\n"
				+ "\n total management Fee: %s", name, taxId, propertyList, getTotalRent() * (mgmtFeePercent / 100));
	}
}
