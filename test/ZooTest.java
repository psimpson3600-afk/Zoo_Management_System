import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZooTest {

    @Test
    public void testAddAnimal() {
        Zoo zoo = new Zoo("Belfast Zoo");
        Animal monkey = new Monkey("Rex", 5, "Brown", 20, 5);
        zoo.addAnimal(monkey);
        assertEquals(1, zoo.getAnimals().size());
    }

    @Test
    public void testRemoveAnimal() {
        Zoo zoo = new Zoo("Belfast Zoo");
        Animal monkey = new Monkey("Rex", 5, "Brown", 20, 5);
        zoo.addAnimal(monkey);
        zoo.removeAnimal("rex");
        assertEquals(0, zoo.getAnimals().size());
    }

    @Test
    public void testMakeSound() {
        Animal monkey = new Monkey("Rex", 5, "Brown", 20, 5);
        String sound = monkey.makeSound();
        assertTrue(sound.contains("Ooh!"));
    }
}
