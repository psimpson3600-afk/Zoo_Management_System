public class Monkey extends Animal {

    // Extra variable specific to Monkey

    private int tailLength;

    /* Constructor — calls super() to set main Animal fields,then sets the Monkey-specific tailLength variable.*/

    public Monkey(String name, int age, String colour, double weight, int tailLength) {
        super(name, age, colour, weight);
        this.tailLength = tailLength;
    }


    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    /*Overrides makeSound() to return a monkey specific string*/

    @Override
    public String makeSound() {
        return "Ooh! I am " + getName() + ", a " + getAge() + " year old monkey";
    }

    /*Overrides toString to print base animal details plus tail length*/

    @Override
    public String toString(){
        return super.toString() + "\ntailLength: " + getTailLength();
    }
}
