import java.util.Scanner;

public class Main {

    /*Entry point of the program.
      takes user inputs for menu navigation.*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager filemanager = new FileManager();
        String zooName = filemanager.loadZooDetails(); //loads the zoo name
        Zoo zoo = new Zoo(zooName);
        filemanager.loadAnimalDetails(zoo); //loads the saved animal details

        //Start of main loop
        boolean runProgram = true;
        while(runProgram){
            System.out.println("=== " + zoo.getZooName() + " ===");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Edit Animal");
            System.out.println("4. View All Animals");
            System.out.println("5. Search by Name");
            System.out.println("6. Search by Colour");
            System.out.println("7. Zoo Report");
            System.out.println("8. Daily Care");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                //Adds an animal type with relevant data
                case 1:{
                    System.out.println("What type of animal would you like to add?");
                    System.out.println("1. Monkey");
                    System.out.println("2. Bird");
                    System.out.println("3. Fish");
                    int animalType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter colour: ");
                    String colour = scanner.nextLine();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();

                    if(animalType == 1){
                        System.out.print("Enter tail length: ");
                        int tailLength = scanner.nextInt();
                        scanner.nextLine();
                        Monkey m = new Monkey(name, age, colour, weight, tailLength);
                        zoo.addAnimal(m);
                    }else if(animalType == 2){
                        System.out.print("Enter species: ");
                        String species = scanner.nextLine();
                        System.out.print("Can it fly (true/false): ");
                        boolean canFly = scanner.nextBoolean();
                        scanner.nextLine();
                        System.out.print("Wings are healthy?(true/false): ");
                        boolean wingsHealthy = scanner.nextBoolean();
                        scanner.nextLine();
                        Bird b = new Bird(name, age, colour, weight, species, canFly, wingsHealthy);
                        zoo.addAnimal(b);
                    }else if(animalType == 3) {
                        System.out.print("Enter water type: ");
                        String waterType = scanner.nextLine();
                        System.out.print("Is it eating true/false: ");
                        boolean isEating = scanner.nextBoolean();
                        scanner.nextLine();
                        System.out.print("Are it's fins healthy (true/false): ");
                        boolean finHealth = scanner.nextBoolean();
                        scanner.nextLine();
                        Fish f = new Fish(name, age, colour, weight, waterType, isEating, finHealth);
                        zoo.addAnimal(f);
                    }
                    break;
            }
                //runs remove animal()
                case 2: {
                    System.out.print("Enter the animals name: ");
                    String name = scanner.nextLine();
                    zoo.removeAnimal(name);
                    break;
                }
                //asks for the animals name and the gathers information to replace
                case 3: {
                    System.out.print("Enter the name of the animal you would like to edit: ");
                    String currentName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new colour: ");
                    String newColour = scanner.nextLine();
                    System.out.print("Enter new weight: ");
                    double newWeight = scanner.nextDouble();
                    scanner.nextLine();
                    zoo.editAnimal(currentName, newName, newAge, newColour, newWeight);
                    break;
                }
                //runs viewAllAnimals()
                case 4: {
                    zoo.viewAllAnimals();
                    break;
                }
                // takes name input and searches for it
                case 5: {
                    System.out.println("Enter the animals name: ");
                    String name = scanner.nextLine();
                    zoo.searchByName(name);
                    break;
                }
                // takes colour input and searches for it
                case 6: {
                    System.out.println("Enter the animals colour: ");
                    String colour = scanner.nextLine();
                    zoo.searchByColour(colour);
                    break;
                }
                // runs zooReport()
                case 7: {
                    zoo.zooReport();
                    break;
                }
                // runs dailycare()
                case 8: {
                    zoo.dailyCare();
                    break;
                }
                //saves data then exits the program by making runProgram false
                case 9: {
                    filemanager.saveZooDetails(zoo);
                    filemanager.saveAnimalDetails(zoo.getAnimals());
                    System.out.println("Exiting zoo program");
                    runProgram = false;
                    break;
                }
            }

        }
    }
}
