public class Person {
	
	//Attributes
	private String jobType;
	private String name;
	private String telNumber;
	private String emailAddress;
	private String physicalAddress;

	// Constructor
	public Person(String jobType, String name, String telNumber, String emailAddress,
				  String physicalAddress) {
		this.jobType = jobType;
		this.name = name;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}

	public String getName() {
		return name;
	}

	public String getJobType() {
		return jobType;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setTelNumber(String newTelNumber) {
		telNumber = newTelNumber;
	}
	
	public void setEmailAddress(String newEmailAddress) {
		emailAddress = newEmailAddress;
	}
	
}
