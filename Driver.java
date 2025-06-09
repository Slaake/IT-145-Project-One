import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();

        char input = 0;
        int input1 = Character.getNumericValue(input);
        boolean isValidSelection = true;

        // Add a menu loop for the user to select what they would like to do
        displayMenu();
        do {
            isValidSelection = true;
            try {
                input = scanner.nextLine().charAt(0);
                if (input == 'q') {
                    System.out.print("Thank you for using Grazioso Salvare Animal Tracking Software!");
                    System.exit(0);
                } else {
                    input1 = Character.getNumericValue(input);
                }
                if (input1 < 1 || input1 > 6)
                    throw new Exception("Invalid Entry. Please try again");
            } catch (Exception execpt) {
                System.out.println(execpt.getMessage());
                isValidSelection = false;
            }
        } while (!isValidSelection);

        switch (input1) { //Switch statement to determine which menu option the user selected
            case 1 -> intakeNewDog(scanner);
            case 2 -> intakeNewMonkey(scanner);
            case 3 -> reserveAnimal(scanner);
            case 4 -> printDogs();
            case 5 -> printMonkey();
            case 6 -> printAnimals();
        }
    }

    // This method prints the menu options to the user
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Abe", "Capuchin", "5", "10", "7", "male", "3", "12", "01-02-2023", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Ben", "Guenon", "6", "11", "8", "female", "4", "13", "02-03-2024", "Germany", "Phase I", true, "United States");
        Monkey monkey3 = new Monkey("Carl", "Macaque", "7", "12", "9", "male", "5", "14", "05-06-2027", "Canada", "Phase II", false, "United States");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        System.out.println("What is the dog's breed?"); // Ask user for dogs breed
        String breed = scanner.nextLine();

        System.out.println("What is the dog's gender?"); // Ask user for dogs gender
        String gender = scanner.nextLine();

        System.out.println("What is the dog's age?"); // Ask user for dogs age
        String age = scanner.nextLine();

        System.out.println("What is the dog's weight?"); // Ask user for dogs weight
        String weight = scanner.nextLine();

        System.out.println("What is the dog's acquisition date?"); // Ask user for dogs acquisition date
        String acqDate = scanner.nextLine();

        System.out.println("What is the dog's acquisition country?"); // Ask user for dogs acquisition country
        String acqCountry = scanner.nextLine();

        System.out.println("What is the dog's training status?"); // Ask user for dogs training status
        String ts = scanner.nextLine();

        System.out.println("Is the dog reserved (true or false)?"); // Ask user for dogs reservation status
        boolean res = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("What is the dog's in service country?"); // Ask user for dogs service country
        String isc = scanner.nextLine();

        Dog newdog = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, ts, res, isc);
        dogList.add(newdog);
        System.out.println("The information has been successfully added.");
    }

        // Complete intakeNewMonkey
	    //Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also validate the input
	    // to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for (Monkey monkey: monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            System.out.println("What is the monkey's species?");
            String species = scanner.nextLine();

            // This for statement checks for
            for (Monkey monkey: monkeyList) { // Checks if monkey species is allowed
                if (!(species.equalsIgnoreCase("Capuchin")) && !(species.equalsIgnoreCase("Guenon")) && !(species.equalsIgnoreCase("Macaque")) && !(species.equalsIgnoreCase("Marmoset")) && !(species.equalsIgnoreCase("Squirrel Monkey")) && !(species.equalsIgnoreCase("Tamarin"))) {
                    System.out.println("This monkey's species is not allowed! Restarting check-in process.");
                    intakeNewMonkey(scanner);
                }
                System.out.println("What is the monkey's tail length?"); //Prompt user for monkey's tail length
                String tailLength = scanner.nextLine();

                System.out.println("What is the monkey's height?"); //Prompt user for monkey's height
                String height = scanner.nextLine();

                System.out.println("What is the monkey's body length?"); //Prompt user for monkey's body length
                String bodyLength = scanner.nextLine();

                System.out.println("What is the monkey's gender?"); //Prompt user for monkey's gender
                String gender = scanner.nextLine();

                System.out.println("What is the monkey's age?"); //Prompt user for monkey's age
                String age = scanner.nextLine();

                System.out.println("What is the monkey's weight?"); //Prompt user for monkey's weight
                String weight = scanner.nextLine();

                System.out.println("What is the monkey's acquisition date?"); //Prompt user for monkey's acquisition date
                String acqDate = scanner.nextLine();

                System.out.println("What is the monkey's acquisition country?"); //Prompt user for monkey's acquisition country
                String acqCountry = scanner.nextLine();

                System.out.println("What is the monkey's training status?"); //Prompt user for monkey's training status
                String ts = scanner.nextLine();

                System.out.println("Is the monkey reserved (true or false)?"); //Prompt user for monkey's reservation status
                boolean res = scanner.nextBoolean();
                scanner.nextLine();

                System.out.println("What is the monkey's in service country?"); //Prompt user for monkey's service country
                String isc = scanner.nextLine();

                Monkey newMonkey = new Monkey(name, species, tailLength, height, bodyLength, gender, age, weight, acqDate, acqCountry, ts, res, isc);
                monkeyList.add(newMonkey);
                System.out.println("The information has been successfully added.");
            }
        }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country

    // This allows for reserving of an animal of Dog or monkey.
    public static void reserveAnimal(Scanner scanner) {
        boolean isValidSelection = true;
        do {
            try {
                System.out.println("Enter animal type. Please use Monkey or Dog:");
                String type = scanner.nextLine();
                isValidSelection = true;

                // Error catching depending on user input
                if (type.equals("Monkey") || type.equals("monkey")) {
                    for (int i = 0; i < monkeyList.size(); i++) {
                        if (!monkeyList.get(i).getReserved())
                            System.out.println(monkeyList.get(i).getName());
                    }
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    for (Monkey obj : monkeyList) {
                        if (obj.getName().equals(name)) {
                            obj.setReserved(true);
                            System.out.println("Name");
                            System.out.println(obj.getName());
                            System.out.print("Reserved status: ");
                            System.out.println(obj.getReserved());
                            return;
                        } else
                            throw new Exception("Invalid Entry. Please try again");
                    }

                    // Error catching on user input
                } else if (type.equals("Dog") || type.equals("dog")) {
                    System.out.println("Name");
                    for (int i = 0; i < dogList.size(); ++i) {
                        if (!dogList.get(i).getReserved())
                            System.out.println(dogList.get(i).getName());
                    }
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    for (Dog obj : dogList) {
                        if (obj.getName().equals(name)) {
                            obj.setReserved(true);
                            System.out.println("Name");
                            System.out.println(obj.getName());
                            System.out.print("Reserved status: ");
                            System.out.println(obj.getReserved());
                            return;
                        } else
                            throw new Exception("Invalid Entry. Please try again");
                    }
                } else
                    throw new Exception("Invalid Entry. Please try again");
            } catch (Exception execpt) {
                System.out.println(execpt.getMessage());
                isValidSelection = false;

            }
        } while (!isValidSelection);

    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
// Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
// Remember that you only have to fully implement ONE of these lists.
// The other lists can have a print statement saying "This option needs to be implemented".
// To score "exemplary" you must correctly implement the "available" list.

    // Loop to print out dog information from the list
    public static void printDogs() {
        System.out.println("Name | " + "Training Status | " + "Age" + "Breed");
        for (int i = 0; i < dogList.size(); i++) {
            System.out.print(dogList.get(i).getName());
            System.out.print(" | ");
            System.out.print(dogList.get(i).getTrainingStatus());
            System.out.print(" | ");
            System.out.print(dogList.get(i).getAge());
            System.out.print(" | ");
            System.out.println(dogList.get(i).getBreed());
        }
    }

    // Loop to pint out dog information from the list
    public static void printMonkey() {
        System.out.println("Name | " + "Training Status | " + "Age | " + "Species");
        for (int i = 0; i < monkeyList.size(); i++) {
            System.out.print(monkeyList.get(i).getName());
            System.out.print(" | ");
            System.out.print(monkeyList.get(i).getTrainingStatus());
            System.out.print(" | ");
            System.out.print(monkeyList.get(i).getAge());
            System.out.print(" | ");
            System.out.println(monkeyList.get(i).getSpecies());
        }
    }

    // Loop to print out information from both dog and monkey lists
    public static void printAnimals() {
        System.out.println("Name");
        for (int i = 0; i < dogList.size(); ++i) {
            if (dogList.get(i).getReserved() && dogList.get(i).getTrainingStatus().equals("in service"))
                System.out.print(dogList.get(i).getName());
        }

        for (int i = 0; i < monkeyList.size(); ++i) {
            if (monkeyList.get(i).getReserved() && monkeyList.get(i).getTrainingStatus().equals("in service"))
                System.out.print(monkeyList.get(i).getName());
        }
    }
}


