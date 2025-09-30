/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Prompt user to input information of themselves and three procedures and display them in the end with credits.
 * Due: 9/29/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

// Import Scanner into project.
import java.util.Scanner;

public class PatientDriverApp {
	public static void main(String[] args) {
		// Declare scanner object, various String, double values, and procedures for user input.
		Scanner keyboard = new Scanner(System.in);
		String firstName, middleName, lastName, address, city, state, zipCode, emergencyContactName, emergencyContactPhone;
		String procName1, procDate1, pracName1;
		String procName2, procDate2, pracName2;
		String procName3, procDate3, pracName3;
		double procCharge1, procCharge2, procCharge3, total;
		Patient patient;
		Procedure proc1, proc2, proc3;
		
		// Prompt user to enter each information and store them in String value.
		System.out.print("Enter First Name: ");
		firstName = keyboard.nextLine();
		System.out.print("Enter Middle Name: ");
		middleName = keyboard.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = keyboard.nextLine();
		System.out.print("Enter Address: ");
		address = keyboard.nextLine();
		System.out.print("Enter City: ");
		city = keyboard.nextLine();
		System.out.print("Enter State: ");
		state = keyboard.nextLine();
		System.out.print("Enter Zip Code: ");
		zipCode = keyboard.nextLine();
		System.out.print("Enter Emergency Contact Name: ");
		emergencyContactName = keyboard.nextLine();
		System.out.print("Enter Emergency Contact Phone: ");
		emergencyContactPhone = keyboard.nextLine();
		
		// Insert previous information into the patient object.
		patient = new Patient(firstName, middleName, lastName, address, city, state, zipCode, emergencyContactName, emergencyContactPhone);
		
		// Prompt user to enter each information onto first procedure.
		System.out.print("Enter Procedure Name: ");
		procName1 = keyboard.nextLine();
		System.out.print("Enter Procedure Date: ");
		procDate1 = keyboard.nextLine();
		System.out.print("Enter Practitioner Name: ");
		pracName1 = keyboard.nextLine();
		System.out.print("Enter Procedure Charge: ");
		procCharge1 = keyboard.nextDouble();
		keyboard.nextLine();
		
		// Create the first procedure.
		proc1 = new Procedure();
		proc1.setProcedureName(procName1);
		proc1.setProcedureDate(procDate1);
		proc1.setPractitionerName(pracName1);
		proc1.setProcedureCharge(procCharge1);
		
		// Prompt user to enter each information onto second procedure.
		System.out.print("Enter Procedure Name: ");
		procName2 = keyboard.nextLine();
		System.out.print("Enter Procedure Date: ");
		procDate2 = keyboard.nextLine();
		System.out.print("Enter Practitioner Name: ");
		pracName2 = keyboard.nextLine();
		System.out.print("Enter Procedure Charge: ");
		procCharge2 = keyboard.nextDouble();
		keyboard.nextLine();
		
		// Create the second procedure.
		proc2 = new Procedure(procName2, procDate2);
		proc2.setPractitionerName(pracName2);
		proc2.setProcedureCharge(procCharge2);
		
		// Prompt user to enter each information onto third procedure.
		System.out.print("Enter Procedure Name: ");
		procName3 = keyboard.nextLine();
		System.out.print("Enter Procedure Date: ");
		procDate3 = keyboard.nextLine();
		System.out.print("Enter Practitioner Name: ");
		pracName3 = keyboard.nextLine();
		System.out.print("Enter Procedure Charge: ");
		procCharge3 = keyboard.nextDouble();
		keyboard.nextLine();
		
		// Create the third procedure.
		proc3 = new Procedure(procName3, procDate3, pracName3, procCharge3);
		
		// Display patient and each procedure.
		displayPatient(patient);
		displayProcedure(proc1);
		displayProcedure(proc2);
		displayProcedure(proc3);
		
		// Calculate total procedure charges and display them.
		total = calculateTotalCharges(proc1, proc2, proc3);
		System.out.println("\nTotal Charges: $" + String.format("%,.2f", total) + "\n");
		
		// Insert credit at the end of program and close the scanner.
		System.out.println("Student Name: Natdanai Boonyaleephan" + "\nMC#: M21191903" + "\nDue Date: 9/29/2025");
		keyboard.close();
	}
	
	static void displayPatient(Patient patient) {
		System.out.println("\n" + patient.toString());
	}
	
	static void displayProcedure(Procedure procedure) {
		System.out.println("\n" + procedure.toString());
	}
	
	static double calculateTotalCharges(Procedure proc1, Procedure proc2, Procedure proc3) {
		return proc1.getProcedureCharge() + proc2.getProcedureCharge() + proc3.getProcedureCharge();
	}
}
