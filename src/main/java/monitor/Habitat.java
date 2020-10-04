package monitor;

/**
 * Habitat Object
 */
public class Habitat {
    private String habitatType;
    private String temperature;
    private String foodSource;
    private String cleanliness;

    public Habitat() {
    }

    public Habitat(String habitatType, String temperature, String foodSource, String cleanliness) {
        this.habitatType = habitatType;
        this.temperature = temperature;
        this.foodSource = foodSource;
        this.cleanliness = cleanliness;
    }

    // Setters
    public void setHabitatType(String habitatType) {
        this.habitatType = habitatType;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setFoodSource(String foodSource) {
        this.foodSource = foodSource;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    // Getters
    public String getHabitatType() {
        return this.habitatType;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public String getFoodSource() {
        return this.foodSource;
    }

    public String getCleanliness() {
        return this.cleanliness;
    }

    @Override
    public String toString() {
        return String.format("Habitat: %s\n", this.habitatType)
                + String.format("Temperature: %s\n", this.temperature)
                + String.format("Food Source: %s\n", this.foodSource)
                + String.format("Cleanliness: %s\n", this.cleanliness);
    }

    public void display() {
        System.out.println(this.toString());
    }
}
