import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * Class with main loop and methods that utilises the
 * Project and person class
 *
 * @author Armand le Roux
 * @version 1.00, 07 Mai 2022*/
public class ProjectManager {

	// Class array variable to store all projects
	/**
	 * Array of project objects that store all projects
	 */
	static Project[] allProjects = new Project[100];

	/**
	 *
	 * Main loop allows user to view or add a project. When a user chooses to view a
	 * project a list of projects is presented to the user. When the user selects a project
	 * from the list they have the option to edit certain attributes of the project. When a
	 * user chooses to add a project they will be asked to input all necessary information
	 * for the creation of a Project() object.
	 *
	 * @param args The command line arguments */
	public static void main(String[] args) {
		// Objects
		Scanner input = new Scanner(System.in);

		// Variables
		String menuOption = " ";

		// Test projects
		Person piet = new Person("Architect", "Piet", "0129956847",
								 "piet@pietworx.co.za", "1 Pietsehuis str");
		Person jan = new Person("Contractor", "Jan", "0129946846",
								"jan@janneman.co.za", "1 Jansehuis str");
		Person gerrie = new Person("Customer", "Gerrie", "0129946846",
								   "gerrie@gertland.co.za", "1 Gertsehuis str");


		allProjects[0] = new Project("2514", "House Johnson", "House",
									 "123 Piet str", "1234", 500000,
								     400000, LocalDate.of(2022, 6, 4), piet, jan, gerrie);
		allProjects[1] = new Project("7814", "House Schoeman", "House",
									 "123 Gert str", "5834", 1000000,
									 200000, LocalDate.of(2022, 8, 15), piet, jan, gerrie);


		while(!menuOption.equals("0")) {

			drawLine();
			System.out.println("""
Project Manager
1: View Projects
2: Add Project
0: Quit""");

			menuOption = input.next();
			input.nextLine();

			// View project
			if (menuOption.equals("1")) {
				processTask(input);
			}
			else if (menuOption.equals("2")) {
					// Add project
				for (int i = 0; i < allProjects.length; i++) {
					if (allProjects[i] == null) {
						allProjects[i] = createProject();
						System.out.println("Added project: " + allProjects[i].getName());
						break;
					}
				}
			}

		}
		input.close();

	}

	/**
	 *
	 * This method allows a user to edit certain attributes of a
	 * project object.
	 *
	 * @param input Scanner for user input.
	 */
	private static void processTask(Scanner input) {
		while (true) {
			int selectedProject;
			while (true) {
				try {
					// Allow user ot select a task.
					drawLine();
					System.out.println("Please choose a project(Type '0'to go back):");

					for (int i = 0; i < allProjects.length; i++) {
						if (allProjects[i] != null) {
							System.out.println((i + 1) + ": " + allProjects[i].getName());
						}
					}
					selectedProject = Integer.parseInt(input.nextLine()) - 1;
					break;
				} catch (NumberFormatException e) {
					System.out.println("No file selected.");
				}
			}

			// Go back to previous menu if user enters 0.
			if (selectedProject == -1) {
				break;
			}

			String userInput = "";
			while (!userInput.equals("0")) {
				// Allow user to edit certain information of the selected task.
				drawLine();
				System.out.println(allProjects[selectedProject]);
				drawLine();
				System.out.println("What would you like to do with project "
								+ allProjects[selectedProject].getName()
								+ "\n1: Change due date.\n2: Change total paid to date."
								+ "\n3: Update contractors contact details.\n"
								+ "4: Finalise project.\n0: Go back.");
				userInput = input.next();
				input.nextLine();
				drawLine();

				switch (userInput) {
					case "1" -> allProjects[selectedProject].setDeadline(changeDueDate(input));
					case "2" -> changeAmountPaid(input, selectedProject);
					case "3" -> changeContractorContacts(input, selectedProject);
					case "4" -> {
						allProjects[selectedProject].finaliseProject();
						drawLine();
						System.out.println("Project finalised!");
						userInput = "0";
					}
				}

			}
		}
	}


	/**
	 *
	 * This method allows the user to update the contact information of
	 * the contractor of a given Project.
	 *
	 * @param input
	 * @param selectedProject
	 */
	private static void changeContractorContacts(Scanner input, int selectedProject) {
		System.out.println("Enter new phone number:");
		String number = input.next();
		input.nextLine();
		System.out.println("Enter new Email address:");
		String email = input.next();
		input.nextLine();
		allProjects[selectedProject].getContractor().setTelNumber(number);
		allProjects[selectedProject].getContractor().setEmailAddress(email);
		drawLine();
		System.out.println("Contractor details updated!");
	}


	/**
	 *
	 * This method allows the user to update the total amount paid
	 * to date on a given Project.
	 *
	 * @param input
	 * @param selectedProject
	 */
	private static void changeAmountPaid(Scanner input, int selectedProject) {
		while (true) {
			try {
				System.out.println("Please enter new total amount paid:");
				float amount = Float.parseFloat(input.nextLine());
				allProjects[selectedProject].setAmountPaidToDate(amount);
				drawLine();
				System.out.println("Amount paid to date updated!");
				break;
			} catch (Exception e) {
				System.out.println("Please enter number only.");
			}
		}
	}

	/**
	 *
	 * Method that requests all necessary information from user to create a
	 * project object.
	 *
	 * @return newly created project object.
	 */
	public static Project createProject() {
		// Objects
		Scanner input = new Scanner(System.in);
		Person architect = null;
		Person contractor = null;
		Person customer = null;

		// Variables
		String projectNumber;
		String name;
		String buildingType;
		String address;
		String erfNumber;
		float totalProjectFees;
		float amountPaidToDate;
		LocalDate deadline;

		drawLine();
		System.out.println("Enter the project number: ");
		projectNumber = input.nextLine();
		drawLine();
		System.out.println("Enter the project name: ");
		name = input.nextLine();
		drawLine();
		System.out.println("Enter the building type: ");
		buildingType = input.nextLine();
		drawLine();
		System.out.println("Enter the project address: ");
		address = input.nextLine();
		drawLine();
		System.out.println("Enter the project ERF number: ");
		erfNumber = input.nextLine();
		drawLine();

		// Basic try/catch check to prevent crashing.
		while (true) {
			try {
				System.out.println("Enter the project total cost: ");
				totalProjectFees = Float.parseFloat(input.nextLine());
				drawLine();
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter numbers only!");
			}
		}
		while (true) {
			try {
				System.out.println("Enter the amount paid to date: ");
				amountPaidToDate = Float.parseFloat(input.nextLine());
				drawLine();
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter numbers only!");
			}
		}
		deadline = changeDueDate(input);
		drawLine();

		// for loop to build 3 Person objects an Architect, contractor and a customer.
		for(int i = 0; i < 3; i++) {
			switch (i) {
				case 0 -> architect = createPerson("Architect");
				case 1 -> contractor = createPerson("Contractor");
				case 2 -> customer = createPerson("Customer");
			}
		}

		// If no name is entered one is created.
		if(name.equals("") && customer != null) {
			String[] splitName = customer.getName().split(" ");
			if(splitName.length != 1) {
				name = buildingType + " " + splitName[splitName.length -1];
			} else{
				name = buildingType + " " + splitName[0];
			}
		}

		return new Project(projectNumber, name, buildingType, address, erfNumber,
						   totalProjectFees, amountPaidToDate, deadline, architect,
						   contractor, customer);
		
	}


	/**
	 *
	 * This method allows you to create a Person object with the
	 * given jobType.
	 *
	 * @param jobType Job type of the Person object.
	 * @return Newly created Person object.
	 */
	private static Person createPerson(String jobType) {

		String personName;
		String telNumber;
		String emailAddress;
		String physicalAddress;

		Scanner personInput = new Scanner(System.in);

		System.out.println("Enter the name of the " + jobType + ": ");
		personName = personInput.nextLine();
		drawLine();
		System.out.println("Enter the tel number of the " + jobType + ": ");
		telNumber = personInput.nextLine();
		drawLine();
		System.out.println("Enter the email address of the " + jobType + ": ");
		emailAddress = personInput.nextLine();
		drawLine();
		System.out.println("Enter the physical address of the " + jobType + ": ");
		physicalAddress = personInput.nextLine();
		drawLine();

		return new Person(jobType, personName, telNumber, emailAddress,
						physicalAddress);
	}

	/**
	 *
	 * This method asks the user to enter a date in String format
	 * and returns it in a LocalDate format.
	 *
	 * @param input Scanner for user input.
	 * @return New date in LocalDate format.
	 */
	private static LocalDate changeDueDate(Scanner input) {

		// Request new Due date from user and update
		// due date of project object.
		LocalDate deadline;
		String[] dateArr;
		String dateStr;

		while (true) {
			int year;
			int month;
			int day;

			System.out.println("Enter the project deadline(YYYY/MM/DD): ");
			dateStr = input.nextLine();
			dateStr = dateStr.replace(" ", "/");
			dateArr = dateStr.split("/");

			try {
				year = Integer.parseInt(dateArr[0]);
				month = Integer.parseInt(dateArr[1]);
				day = Integer.parseInt(dateArr[2]);
				deadline = LocalDate.of(year, month, day);
				break;
			} catch (Exception e) {
				System.out.println("Date format is incorrect.");
			}
		}
		return deadline;
	}

	/**
	 * This method draws a line to the console.
	 */
	public static void drawLine(){
		for(int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
