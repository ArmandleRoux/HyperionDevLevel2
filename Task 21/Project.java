import java.time.LocalDate;

/**
 *
 * The class contains the data and attributes of a building
 * project. This class is dependent of the Person class as
 * you cannot create a project class without a person class.
 *
 * @author Armand le Roux
 * @version 1.00, 07 Mai 2022*/
public class Project {

  //Attributes
  private Person architect;
  private Person contractor;
  private Person customer;

  private String projectNumber;
  private String name;
  private String buildingType;
  private String address;
  private String erfNumber;
  private LocalDate deadline;
  private float totalProjectFees;
  private float amountPaidToDate;
  private boolean isFinalised;


  // Constructor
  /**
   *
   * Constructor
   *
   * @param projectNumber Unique number of project
   * @param name Name of project
   * @param buildingType Type of building
   * @param address Address of project
   * @param erfNumber ERF Number of project
   * @param totalProjectFees Total cost of project
   * @param amountPaidToDate Total already paid for project
   * @param deadline Deadline for project
   * @param architect Architect for the project
   * @param contractor Contractor for the project
   * @param customer Customer of the project*/
  public Project(String projectNumber, String name, String buildingType,
                 String address, String erfNumber, float totalProjectFees,
                 float amountPaidToDate, LocalDate deadline, Person architect,
                 Person contractor, Person customer) {

    this.projectNumber = projectNumber;
    this.name = name;
    this.buildingType = buildingType;
    this.address = address;
    this.erfNumber = erfNumber;
    this.totalProjectFees = totalProjectFees;
    this.amountPaidToDate = amountPaidToDate;
    this.deadline = deadline;
    this.architect = architect;
    this.contractor = contractor;
    this.customer = customer;
  }

  /**
   * Get name of project object.
   *
   * @return Name of project object
   */
  public String getName() {
    return name;
  }

  /**
   * Get contractor of project object.
   *
   * @return Constractor of project object.
   */
  public Person getContractor() {
    return contractor;
  }

  /**
   *
   * Set amountPaidToDate to newAmount given.
   *
   * @param newAmount New amount to set amount paid to date to.
   */
  public void setAmountPaidToDate(float newAmount) {
    amountPaidToDate = newAmount;
  }

  /**
   * Set project deadline to new provided deadline
   *
   * @param newDeadline New deadline to set Project deadline to.
   */
  public void setDeadline(LocalDate newDeadline) {
    deadline = newDeadline;
  }

  /**
   * This method calls the generateInvoice method and
   * sets inFinalised to true.
   */
  // Finalising the project
  public void finaliseProject() {
    if(totalProjectFees - amountPaidToDate > 0) {
      generateInvoice();
    }
    isFinalised = true;
  }

  /**
   * This method generates an invoice that for the customer
   * and prints it to the console.
   */
  // Generate invoice to be saved to textfile
  public void generateInvoice() {
    float amountToBePaid = totalProjectFees - amountPaidToDate;
    String invoice = "Customer: " + customer.getName();
    invoice += "\nTel number: " + customer.getTelNumber();
    invoice += "\nEmail: " + customer.getEmailAddress();
    invoice += "\n\nTotal amount to be paid: R" + amountToBePaid;
    System.out.println(invoice);

  }

  /**
   * This method returns all the information about
   * the object in String format
   *
   * @return All object information in String format.
   */
  // Print data to console in readable format
  public String toString() {
    return ("****************************************************"
            + "\nProject name: " + name
            + "\nProject number: " + projectNumber
            + "\nBuilding type: " + buildingType
            + "\nAddress: " + address
            + "\nERF Number: " + erfNumber
            + "\nDue date: " + deadline
            + "\nArchitect: " + architect.getName()
            + "\n\tTel number:" + architect.getTelNumber()
            + "\n\tEmail:" + architect.getEmailAddress()
            + "\nContractor: " + contractor.getName()
            + "\n\tTel number:" + contractor.getTelNumber()
            + "\n\tEmail:" + contractor.getEmailAddress()
            + "\nCustomer: " + customer.getName()
            + "\n\tTel number:" + customer.getTelNumber()
            + "\n\tEmail:" + customer.getEmailAddress()
            + "\nTotal project fee: R" + totalProjectFees
            + "\nTotal paid to date: R" + amountPaidToDate
            + "\nProject finalised: " + isFinalised
            + "\n****************************************************");
  }
}
