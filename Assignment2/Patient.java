
public class Patient {
	private String firstName, middleName, lastName, address, city, state, zipCode, emergencyContactName, emergencyContactPhone;
	
	Patient() {
		firstName = "";
		middleName = "";
		lastName = "";
		address = "";
		city = "";
		state = "";
		zipCode = "";
		emergencyContactName = "";
		emergencyContactPhone = "";
	}
	
	Patient(String f, String m, String l) {
		firstName = f;
		middleName = m;
		lastName = l;
		address = "";
		city = "";
		state = "";
		zipCode = "";
		emergencyContactName = "";
		emergencyContactPhone = "";
	}
	
	Patient(String f, String m, String l, String addr, String c, String s, String z, String eN, String eP) {
		firstName = f;
		middleName = m;
		lastName = l;
		address = addr;
		city = c;
		state = s;
		zipCode = z;
		emergencyContactName = eN;
		emergencyContactPhone = eP;
	}
	
	public String getFirstName() {return firstName;}
	public String getMiddleName() {return middleName;}
	public String getLastName() {return lastName;}
	public String getAddress() {return address;}
	public String getCity() {return city;}
	public String getState() {return state;}
	public String getZipCode() {return zipCode;}
	public String getEmergencyContactName() {return emergencyContactName;}
	public String getEmergencyContactPhone() {return emergencyContactPhone;}
	
	public void setFirstName(String value) {firstName = value;}
	public void setMiddleName(String value) {middleName = value;}
	public void setLastName(String value) {lastName = value;}
	public void setAddress(String value) {address = value;}
	public void setCity(String value) {city = value;}
	public void setState(String value) {state = value;}
	public void setZipCode(String value) {zipCode = value;}
	public void setEmergencyContactName(String value) {emergencyContactName = value;}
	public void setEmergencyContactPhone(String value) {emergencyContactPhone = value;}
	
	public String buildFullName() {return firstName + " " + middleName + " " + lastName;}
	public String buildAddress() {return address + " " + city + " " + state + " " + zipCode;}
	public String buildEmergencyContact() {return emergencyContactName + " " + emergencyContactPhone;}
	public String toString() {
		return "Name: " + buildFullName() +
				"\nAddress: " + buildAddress() + 
				"\nEmergency Contact: " + buildEmergencyContact();
	}
}
