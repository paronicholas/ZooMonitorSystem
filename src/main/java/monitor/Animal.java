package monitor;

/**
 * Animal Object
 */
public class Animal {
    private String animalType;
    private String name;
    private String age;
    private String healthConcern;
    private String feedingSchedule;

    public Animal() {
    }

    public Animal(String animalType, String name, String age, String healthConcern, String feedingSchedule) {
        this.animalType = animalType;
        this.name = name;
        this.age = age;
        this.healthConcern = healthConcern;
        this.feedingSchedule = feedingSchedule;
    }

    // Setters
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String  age) {
        this.age = age;
    }

    public void setHealthConcern(String healthConcern) {
        this.healthConcern = healthConcern;
    }

    public void setFeedingSchedule(String feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    // Getters
    public String getAnimalType() {
        return this.animalType;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public String getHealthConcern() {
        return this.healthConcern;
    }

    public String getFeedingSchedule() {
        return this.feedingSchedule;
    }

    @Override
    public String toString() {
        return String.format("Animal: %s\n", this.animalType)
                + String.format("Name: %s\n", this.name)
                + String.format("Age: %s\n", this.age)
                + String.format("Health Concern: %s\n", this.healthConcern)
                + String.format("Feeding Schedule: %s\n", this.feedingSchedule);
    }

    public void display() {
        System.out.println(this.toString());
    }
}
