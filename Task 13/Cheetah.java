package AnimalTask;

public class Cheetah extends Animal {

    // Attributes
    String[] typesOfPray = new String[15];
    private static float maxSpeed = 60;

    public Cheetah(int numTeeth, boolean spots, int weight) {
        super(numTeeth, spots, weight);
    }

    public String toString() {
        String sentence = "Number of teeth: " + getNumTeeth();
        sentence += "\nWeight: " + getWeight() + "kg";
        sentence += "\nHas spots: " + getSpots();
        sentence += "\nMax speed: " + maxSpeed + "km/h";
        return sentence;
    }

    public static void setMaxSpeed(float speed) {
        maxSpeed = speed;
    }

    public static float getMaxSpeed(){
        return maxSpeed;
    }
}
