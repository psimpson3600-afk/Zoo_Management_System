public class Fish extends Animal implements Swimmable {

    // Extra variable specific to Fish

    private String waterType;
    private boolean isEating;
    private boolean finHealth;

    /* Constructor — calls super() to set main Animal fields,then sets the Fish-specific waterType, isEating,
     finHealth variables.*/

    public Fish(String name, int age, String colour, double weight, String waterType, boolean isEating,
                boolean finHealth) {

        super(name, age, colour, weight);
        this.waterType = waterType;
        this.isEating = isEating;
        this.finHealth = finHealth;
    }

    public String getWaterType() {

        return waterType;
    }

    public boolean isEating() {

        return isEating;
    }

    public boolean isFinHealth() {

        return finHealth;
    }

    public void setWaterType(String waterType) {

        this.waterType = waterType;
    }

    public void setEating(boolean eating) {

        isEating = eating;
    }

    public void setFinHealth(boolean finHealth) {

        this.finHealth = finHealth;
    }


    public String eating() {
        if(isEating){
            return getName() + " is eating";
        }
        return getName() + " isn't eating";
    }

    /*Overrides makeSound() to return a Fish specific string*/

    @Override
    public String makeSound() {

        return "Blub! I am " + getName() + ", a " + getAge() + " year old " + getWaterType() + " fish";

    }

    /*Overrides toString to print base animal details plus Fish specific values*/

    @Override
    public String toString(){
        return super.toString() + "\nWater type: " + getWaterType() + "\nIs eating: " + eating() +
                "\nFin Health: " + checkFins();
    }

    /*Implements checkFins() from the Swimmable interface and returns if its fins are healthy or not*/

    @Override
    public String checkFins() {
        if(finHealth){
            return "Fins are healthy";
        }
        return "Fins are damaged";
    }
}
