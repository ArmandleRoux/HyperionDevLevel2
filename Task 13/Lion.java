package AnimalTask;

public class Lion extends Animal {
    // Attributes
    private String lionType;

    // Constructor
    public Lion(int numTeeth, boolean spots, int weight) {
        super(numTeeth, spots, weight);
        this.setLionType();
    }

    public void setLionType(){
        if (getWeight() <= 80) {
            lionType = "cub";
        }
        else if(getWeight() >80 && getWeight() <= 120){
            lionType = "female";
        }
        else if(getWeight() > 120){
            lionType = "male";
        }
    }

    public String toString() {
        String sentence = "Lion type: " + lionType;
        sentence += "\nNumber of teeth: " + getNumTeeth();
        sentence += "\nWeight: " + getWeight() + "kg";
        sentence += "\nHas spots: " + getSpots();
        return sentence;
    }
}

