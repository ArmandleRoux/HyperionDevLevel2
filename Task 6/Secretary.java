package level_2;

public class Secretary {
	
	// Attributes.
	String name;
	String office;
	String officeNumber;
	String jobDescription;
	double salary;
	
	// Constructor.
	public Secretary(String name, String office, String office_Number,
									 String jobDescription, double salary) {
		this.name = name;
		this.office = office;
		this.officeNumber = office_Number;
		this.jobDescription = jobDescription;
		this.salary = salary;
	}
	
	// Method to return data of class in readable string format.
	public String toString() {
		String output = "Name: " + name;
		output += "\nOffice: " + office;
		output += "\nOffice Number: " + officeNumber;
		output += "\nJob Description: " + jobDescription;
		output += "\nSalary: " + salary;
		
		return output;
	}
	
	
}
