/**
 *
 * The class contains the attributes for a person involved
 * with a project such as the Architect, contractor or
 * customer.
 *
 * @author Armand le Roux
 * @version 1.00, 07 Mei 2022
 */
public class Person {
	
	//Attributes
	private String jobType;
	private String name;
	private String telNumber;
	private String emailAddress;
	private String physicalAddress;

	// Constructor
	/**
	 *
	 * Constructor
	 *
	 * @param jobType Job type of person
	 * @param name Name of person
	 * @param telNumber Tel number person
	 * @param emailAddress Email address of person
	 * @param physicalAddress Physical address of person */
	public Person(String jobType, String name, String telNumber, String emailAddress,
				  String physicalAddress) {
		this.jobType = jobType;
		this.name = name;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}

	/**
	 *
	 * The method returns the name of the Person object.
	 *
	 * @return name
	 * @since version 1.00
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * The method returns the job type of the Person object.
	 *
	 * @return jobType
	 * @since version 1.00
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 *
	 * The method returns the tel number of the Person object.
	 *
	 * @return telNumber
	 * @since version 1.00
	 */
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 *
	 * The method returns the email address of the Person object.
	 *
	 * @return emailAddress
	 * @since version 1.00
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 *
	 * The method returns the physical of the Person object.
	 *
	 * @return physicalAddress
	 * @since version 1.00
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	/**
	 *
	 * The method sets the tel number of the Person object to
	 * a new given value.
	 *
	 * @param newTelNumber new value to set telNUmber to.
	 * @since version 1.00
	 * */
	public void setTelNumber(String newTelNumber) {
		telNumber = newTelNumber;
	}

	/**
	 *
	 * The method sets the email address of the Person object to
	 * a new given value.
	 *
	 * @param newEmailAddress new value to set emailAddress to.
	 * @since version 1.00
	 * */
	
	public void setEmailAddress(String newEmailAddress) {
		emailAddress = newEmailAddress;
	}
	
}