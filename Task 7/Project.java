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
  private String deadline;
  private float totalProjectFees;
  private float amountPaidToDate;
  private boolean isFinalised;


  // Constructor
  public Project(String projectNumber, String name, String buildingType,
                 String address, String erfNumber, float totalProjectFees,
                 float amountPaidToDate, String deadline, Person architect,
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

  public String getName() {
    return name;
  }

  public Person getContractor() {
    return contractor;
  }

  public void setAmountPaidToDate(float newAmount) {
    amountPaidToDate = newAmount;
  }

  public void setDeadline(String newDeadline) {
    deadline = newDeadline;
  }

  public void finaliseProject() {
    if(totalProjectFees - amountPaidToDate > 0) {
      generateInvoice();
    }
    isFinalised = true;
  }


  // Generate invoice to be saved to textfile
  public void generateInvoice() {
    float amountToBePaid = totalProjectFees - amountPaidToDate;
    String invoice = "Customer: " + customer.getName();
    invoice += "\nTel number: " + customer.getTelNumber();
    invoice += "\nEmail: " + customer.getEmailAddress();
    invoice += "\n\nTotal amount to be paid: R" + amountToBePaid;
    System.out.println(invoice);

  }

  // Print data to console in readable format
  public String toString() {
    return  ("****************************************************"
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
