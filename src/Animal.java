public abstract class Animal {
    /*Abstracted as it is a base class and won't be called*/
    private String name;
    private int  age;
    private String colour;
    private double weight;

    /* Constructor to initialise a new Animal with its main attributes.*/

    public Animal(String name, int age, String colour, double weight){
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    // Getters — allow other classes to read private variables

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }

    public double getWeight() {
        return weight;
    }

    // Setters — allow other classes to update private variables

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColour(String colour) {

        this.colour = colour;
    }

    public void setWeight(double weight) {
        this.weight = weight;

    }
    /*Abstract means that it must be overridden by every subclass*/
    public abstract String makeSound();

    /*Allows extra values to be added to the string in subclasses*/
    @Override
    public String toString(){
    return "Name: " + getName()  + "\nAge: " + getAge() + "\nColour: " + getColour() +
            "\nWeight: " + getWeight();
    }
}