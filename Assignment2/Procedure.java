
public class Procedure {
	private String procedureName, procedureDate, practitionerName;
	private double procedureCharge;
	
	Procedure() {
		procedureName = "";
		procedureDate = "";
		practitionerName = "";
		procedureCharge = 0.0;
	}
	
	Procedure(String name, String date) {
		procedureName = name;
		procedureDate = date;
		practitionerName = "";
		procedureCharge = 0.0;
	}
	
	Procedure(String name, String date, String practitioner, double charge) {
		procedureName = name;
		procedureDate = date;
		practitionerName = practitioner;
		procedureCharge = charge;
	}
	
	public String getProcedureName() {return procedureName;}
	public String getProcedureDate() {return procedureDate;}
	public String getPractitionerName() {return practitionerName;}
	public double getProcedureCharge() {return procedureCharge;}
	
	public void setProcedureName(String value) {procedureName = value;}
	public void setProcedureDate(String value) {procedureDate = value;}
	public void setPractitionerName(String value) {practitionerName = value;}
	public void setProcedureCharge(double value) {procedureCharge = value;}
	
	public String toString() {
		return "\tProcedure: " + procedureName +
				"\n\tProcedureDate=" + procedureDate +
				"\n\tPractitioner=" + practitionerName +
				"\n\tCharge=" + String.format("%.2f", procedureCharge);
	}
}
