import java.util.Scanner;

public class projectManager {

	// Class array variable to store all projects
	static Project[] allProjects = new Project[100];

	/* Main loop allows user to view or add a project. When a user chooses to view a
	 * project a list of projects is presented to the user. When the user selects a project
	 * from the list they have the option to edit certain attributes of the project. When a
	 * user chooses to add a project they will be asked to input all necessary information
	 * for the creation of a Project() object. */
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
								     400000, "04/06/2022", piet, jan, gerrie);
		allProjects[1] = new Project("7814", "House Schoeman", "House",
									 "123 Gert str", "5834", 1000000,
									 200000, "04/06/2022", piet, jan, gerrie);


		while(!menuOption.equals("0")) {

			drawLine();
			System.out.println("Project Manager\n1: View Projects\n2: Add Project"
							   + "\n0: Quit");

			menuOption = input.next();
			input.nextLine();

			// View project
			if (menuOption.equals("1")) {
				while (true) {
					// Allow user ot select a task.
					drawLine();
					System.out.println("Please choose a project(Type '0'to go back):");

					for (int i = 0; i < allProjects.length; i++) {
						if (allProjects[i] != null) {
							System.out.println((i + 1) + ": " + allProjects[i].getName());
						}
					}
					int selectedProject = input.nextInt() - 1;

					if(selectedProject == -1) {
						break;
					}

					while (true) {
						// Allow user to edit certain information of the selected task.
						drawLine();
						System.out.println(allProjects[selectedProject]);
						drawLine();
						System.out.println("What would you like to do with project "
								+ allProjects[selectedProject].getName()
								+ "\n1: Change due date.\n2: Change total paid to date."
								+ "\n3: Update contractors contact details.\n"
								+ "4: Finalise project.\n0: Go back.");
						String userInput = input.next();
						input.nextLine();
						drawLine();

						if (userInput.equals("1")) {
							changeDueDate(input, selectedProject);
						} else if (userInput.equals("2")) {
							changeAmountPaid(input, selectedProject);
						} else if (userInput.equals("3")) {
							changeContractorContacts(input, selectedProject);
						} else if (userInput.equals("4")) {
							allProjects[selectedProject].finaliseProject();
							drawLine();
							System.out.println("Project finalised!");
							break;
						} else if (userInput.equals("0")) {
							break;
						}

					}
				}
			} else if (menuOption.equals("2")) {
				// Add project
				for(int i = 0; i < allProjects.length; i++) {
					System.out.println("Working");
					if(allProjects[i] == null) {
						allProjects[i] = createProject();
						System.out.println("Added project: "+ allProjects[i].getName());
						break;
					}
				}

			}

		}
		input.close();

	}

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

	private static void changeDueDate(Scanner input, int selectedProject) {
		System.out.println("Enter new due date (DD/MM/YYYY):");
		String newDate = input.nextLine();
		newDate = newDate.strip();
		newDate = newDate.replace(" ", "/");
		allProjects[selectedProject].setDeadline(newDate);
		drawLine();
		System.out.println("Due date updated!");
	}

	// Method that requests all necessary information from user to create a
	// project object.
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
		String deadline;
		String jobType = "";
		String personName;
		String telNumber;
		String emailAddress;
		String physicalAddress;

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
			} catch (Exception e) {
				System.out.println("Please enter numbers only!");
			}
		}
		while (true) {
			try {
				System.out.println("Enter the amount paid to date: ");
				amountPaidToDate = Float.parseFloat(input.nextLine());
				drawLine();
				break;
			} catch (Exception e) {
				System.out.println("Please enter numbers only!");
			}
		}
		System.out.println("Enter the project deadline(DD/MM/YYYY): ");
		deadline = input.nextLine();
		//input.nextLine();
		drawLine();
		deadline = deadline.strip();
		deadline = deadline.replace(" ", "/");

		// for loop to build 3 Person objects an Architect, contractor and a customer.
		for(int i = 0; i < 3; i++) {
			if(i == 0) {
				jobType = "Architect";
			} else if(i == 1) {
				jobType = "Contractor";
			} else if(i == 2) {
				jobType = "Customer";
			}
			
			System.out.println("Enter the name of the " + jobType + ": ");
			personName = input.nextLine();
			drawLine();
			System.out.println("Enter the tel number of the " + jobType + ": ");
			telNumber = input.nextLine();
			drawLine();
			System.out.println("Enter the email address of the " + jobType + ": ");
			emailAddress = input.nextLine();
			drawLine();
			System.out.println("Enter the physical address of the " + jobType + ": ");
			physicalAddress = input.nextLine();
			drawLine();

			if(i == 0) {
				architect = new Person(jobType, personName, telNumber, emailAddress,
						               physicalAddress);
			} else if(i == 1) {
				contractor = new Person(jobType, personName, telNumber, emailAddress,
										physicalAddress);
			} else if(i == 2) {
				customer = new Person(jobType, personName, telNumber, emailAddress,
						              physicalAddress);
			}
		}

		// If no name is entered one is created.
		if(name.equals("")) {
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

	// Draws line to console
	public static void drawLine(){
		for(int i = 0; i < 80; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
