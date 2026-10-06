import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    /*Saves the zoo name to a text file.*/

    public void saveZooDetails(Zoo zoo){
        try{
            PrintWriter writer = new PrintWriter("zooDetails.txt");
            writer.println(zoo.getZooName());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    /*Saves all animal objects after validation to a text file.
    Uses instanceof to determine the type of animal and store relevant data.*/

    public void saveAnimalDetails(ArrayList<Animal> animals){
        try{
            PrintWriter writer = new PrintWriter("animalDetails.txt");
            for(Animal a : animals) {
                if (!a.getName().isEmpty() && !a.getColour().isEmpty() &&
                        a.getAge() >= 0 && a.getWeight() > 0) {
                    if (a instanceof Monkey) {
                        writer.println("Monkey, " + a.getName() + ", " + a.getAge() + ", " + a.getColour()
                                + ", " + a.getWeight() + ", " + ((Monkey) a).getTailLength());
                    } else if (a instanceof Fish) {
                        writer.println("Fish, " + a.getName() + ", " + a.getAge() + ", " + a.getColour()
                                + ", " + a.getWeight() + ", " + ((Fish) a).getWaterType()
                                + ", " + ((Fish) a).isFinHealth() + ", " + ((Fish) a).isEating());
                    } else if (a instanceof Bird) {
                        writer.println("Bird, " + a.getName() + ", " + a.getAge() + ", " + a.getColour()
                                + ", " + a.getWeight() + ", " + ((Bird) a).getSpecies()
                                + ", " + ((Bird) a).isWingsHealthy() + ", " + ((Bird) a).isCanFly());
                    }
                }
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Error saving file");
        }
    }

    /*Loads the zoo name from file.
      returns The zoo name, or "Default Zoo" if file fails to load.*/

    public String loadZooDetails(){
        try {
            FileReader fileReader = new FileReader("zooDetails.txt");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String zooName = buffReader.readLine();
            buffReader.close();
            return zooName;
        } catch(IOException e){
            System.out.println("Error loading file");
        }
        return "Default Zoo";
    }

    /*Loads animal data from file and recreates objects.
      Adds each animal to the zoo.*/

    public void loadAnimalDetails(Zoo zoo){
        try{
            FileReader fileReader = new FileReader("animalDetails.txt");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String animalDetails = buffReader.readLine();
            while(animalDetails != null){
                String[] parts = animalDetails.split(",");
                animalDetails = buffReader.readLine();
                if(parts[0].equals("Monkey")){
                    Monkey m = new Monkey(
                            parts[1],Integer.parseInt(parts[2].trim()), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()),Integer.parseInt(parts[5].trim())
                    );
                    zoo.addAnimal(m);
                } else if (parts[0].equals("Fish")) {
                    Fish f = new Fish(parts[1],Integer.parseInt(parts[2].trim()), parts[3].trim(),
                            Double.parseDouble(parts[4].trim()),parts[5].trim(),
                            Boolean.parseBoolean(parts[6].trim()),Boolean.parseBoolean(parts[7].trim())
                    );
                    zoo.addAnimal(f);
                }else if(parts[0].equals("Bird")){
                    Bird b = new Bird(
                            parts[1],
                            Integer.parseInt(parts[2].trim()),
                            parts[3].trim(),
                            Double.parseDouble(parts[4].trim()),
                            parts[5].trim(),                       // species
                            Boolean.parseBoolean(parts[6].trim()), // canFly
                            Boolean.parseBoolean(parts[7].trim())  // wingsHealthy
                    );
                    zoo.addAnimal(b);
                }
            }
            buffReader.close();
        }catch(IOException e){
            System.out.println("Error loading file");
        }
    }
}
