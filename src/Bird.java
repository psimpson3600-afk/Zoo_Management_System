public class Bird extends Animal implements Flyable{

    // Extra variable specific to Bird
    private String species;
    private boolean canFly;
    private boolean wingsHealth;

    /* Constructor — calls super() to set main Animal fields,then sets the Bird-specific species, canFly,
     wingsHealthy variables.*/

    public Bird(String name, int age, String colour, double weight, String species, boolean canFly,
                boolean wingsHealthy) {
        super(name, age, colour, weight);
        this.species = species;
        this.canFly = canFly;
        this.wingsHealth = wingsHealthy;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isWingsHealthy() {
        return wingsHealth;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public void setWingsHealthy(boolean wingsHealthy) {
        this.wingsHealth = wingsHealthy;
    }

    /*Overrides makeSound() to return a Bird specific string*/

    @Override
    public String makeSound() {
        return "Tweet! I am " + getName() + ", a " + getAge() + " year old " + getSpecies();
    }

    /*Overrides toString to print base animal details plus Bird specific values*/

    @Override
    public String toString(){
        return super.toString() + "\nSpecies: " + getSpecies() + "\nCan Fly: " + fly() +
                "\nWing Health: " + checkWings();
    }

    /*Implements Fly() from the flyable interface and returns if it can or can't fly*/

    @Override
    public String fly() {
        if(canFly){
            return getName() + " can fly";
        }
        return getName() + " can't fly";
    }

    /*Implements checkWings() from the flyable interface and returns if its wings are healthy or not*/

    @Override
    public String checkWings() {
        if(wingsHealth){
            return "Wings are healthy";
        }
        return "Wings are damaged";
    }
}
