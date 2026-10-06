import java.util.ArrayList;

public class Zoo {

    private String zooName;
    private ArrayList<Animal> animals;

    /*creates a zoo with a specific name*/

    public Zoo(String zooName) {
        this.zooName = zooName;
        this.animals = new ArrayList<>();
    }


    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public ArrayList<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    /*Adds a new animal to the zoo after validating its data.
     Prevents invalid entries.*/

    public void addAnimal(Animal animal) {
        if(animal == null){
            System.out.println("Error: Animal is empty");
        }
        else if (animal.getName().isEmpty()){
            System.out.println("Error: Animal name is empty");
        }else if(animal.getAge() < 0){
            System.out.println("Animal age less than 0");
        } else if(animal.getColour().isEmpty()){
            System.out.println("Error: Animal colour is empty");
        }else if(animal.getWeight() <= 0) {
            System.out.println("Error: Animal weight is empty or less than 0");
        }else {
            animals.add(animal);
            System.out.println("Animal added successfully");
        }
    }

    /*Removes an animal from the zoo by name.
      Doesn't care about the case of the word.*/

    public void removeAnimal(String name) {
        boolean found = false;
        for (Animal a : animals){
            if(a.getName().trim().equalsIgnoreCase(name.trim())){
                animals.remove(a);
                System.out.println(name + " removed successfully");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(name +" not found");
        }
    }

    /*Displays all animals currently in the zoo.
      If no animals exist, a message is shown.*/

    public void viewAllAnimals(){

        if (animals.isEmpty()){
            System.out.println("no animals registered");
        }else{
            for (Animal i : animals){
                System.out.println(i);
            }
        }
    }

    /*Searches for an animal by name.
      Displays animal details and its sound if found.*/

    public void searchByName(String name) {
        boolean found = false;
        for (Animal a : animals){
            if(a.getName().trim().equalsIgnoreCase(name.trim())){
                System.out.println(a);
                System.out.println(a.makeSound());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(name +" not found");
        }
    }

    /*Searches for an animal by colour.
      Displays all animal details and their sound if found.*/

    public void searchByColour(String colour) {
        boolean found = false;
        for (Animal a : animals){
            if(a.getColour().trim().equalsIgnoreCase(colour.trim())){
                System.out.println(a);
                System.out.println(a.makeSound());
                found = true;
            }
        }
        if(!found){
            System.out.println(colour +" not found");
        }
    }

    /*Gets the name of the animal you would like to edit.
      Edits that animal's details after validation.*/

    public void editAnimal(String name, String newName, int newAge, String newColour, double newWeight) {
        boolean found = false;
        for (Animal a : animals){
            if(a.getName().trim().equalsIgnoreCase(name.trim())){
                found = true;
                if(newName.isEmpty()){
                    System.out.println("Error: New name is empty");
                }else if(newAge < 0){
                    System.out.println("Error: New age is less than 0");
                }else if(newColour.isEmpty()){
                    System.out.println("Error: New colour is empty");
                }else if(newWeight <= 0){
                    System.out.println("Error: New weight is empty or less than 0");
                }else {
                    a.setName(newName);
                    a.setAge(newAge);
                    a.setColour(newColour);
                    a.setWeight(newWeight);
                    System.out.println(name + " updated successfully");
                    break;
                }
            }
        }
        if(!found){
            System.out.println(name + " not found");
        }
    }

    /*Generates a report showing the number of each animal type and the most dominant colour*/

    public void zooReport(){
        int monkeyCount = 0;
        int fishCount = 0;
        int birdCount = 0;
        String dominantColour = "";
        int highestCount = 0;

        System.out.println("-----------" + zooName + "-----------");
        for (Animal a : animals){
            if(a instanceof Monkey){
                monkeyCount++;

            } else if (a instanceof Fish) {
                fishCount++;
            }else if (a instanceof Bird) {
                birdCount++;
            }
            int count = 0;

            String currentColour = a.getColour();
            for(Animal b : animals){
                if(b.getColour().equals(currentColour)){
                    count++;
                }
            }
            if(count > highestCount){
                highestCount = count;
                dominantColour = currentColour;
            }
        }
        System.out.println("Monkeys: " + monkeyCount);
        System.out.println("Fish: " + fishCount);
        System.out.println("Birds: " + birdCount);
        System.out.println("Dominant Colour: " + dominantColour);
    }

    /*Performs daily care for all animals.
      Uses interfaces Flyable and Swimmable to perform specific actions.*/

    public void dailyCare(){
        for(Animal a : animals){
            System.out.println("Performing daily care for " + a.getName());
            if(a instanceof Flyable){
                System.out.println(((Flyable) a).checkWings());
            }

            if(a instanceof Swimmable){
                System.out.println(((Swimmable) a).checkFins());
            }
        }
    }
}
