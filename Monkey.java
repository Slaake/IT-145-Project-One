public class Monkey extends RescueAnimal {

    // Instance variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructor for the monkey class
    public Monkey(String name, String species, String tailLength, String height, String bodyLength, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {

        setName(name);
        setSpecies(species);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("monkey"); // Sets the animalType to monkey
    }

    // This is the accessor for tail length of the monkey
    public String getTailLength() {
        return tailLength;
    }

    //This is the mutator for the tail length for the monkey
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // This is the accessor for the height of the monkey
    public String getHeight() {
        return height;
    }

    // This is the mutator for the height of the monkey
    public void setHeight(String height) {
        this.height = height;
    }

    // This is the accessor for the body length of the monkey
    public String getBodyLength() {
        return bodyLength;
    }

    // This is the mutator for the body length of the monkey
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    // This is the accessor for the species of the monkey
    public String getSpecies() {
        return species;
    }

    // This is the mutator for the species of the monkey
    public void setSpecies(String species) {
        this.species = species;
    }

}
