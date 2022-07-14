package level_2;

public class Teacher {

	// Attributes
	String name;
	String subject;
	int totalStudents;
	int totalClasses;
	double salary;
	
	// Constructor
	public Teacher(String name, String subject, int total_Students, int total_Classes,
								 double salary) {
		this.name = name;
		this.subject = subject;
		this.totalStudents = total_Students;
		this.totalClasses = total_Classes;
		this.salary = salary;
	}
	
	// Method to return data of class in readable string format.
	public String toString() {
		String output = "Name: " + name;
		output += "\nSubject: " + subject;
		output += "\nTotal Students: " + totalStudents;
		output += "\nTotal Classes: " + totalClasses;
		output += "\nSalary : R" + salary;
		
		return output;
	}
		
}
