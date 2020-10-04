package helper;

import static helper.MonitorSystemOutputStatic.EXIT;
import static helper.MonitorSystemOutputStatic.LINE_SEPARATOR;
import static helper.MonitorSystemOutputStatic.MONITOR_MENU_TITLE;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import monitor.Animal;
import monitor.Habitat;
import org.junit.Test;

public class ParseTest {
    private static final int ANIMAL_CHOICE = 1;
    private static final int HABITAT_CHOICE = 2;

    private static final List<String> EXPECTED_ANIMAL_FILE = new ArrayList<>(Arrays.asList(
            "Details on lions",
            "Details on tigers",
            "Details on bears",
            "Details on giraffes",
            "Details on wolves",
            "Details on pandas",
            "Animal - Lion",
            "Name: Leo",
            "Age: 5",
            "*****Health concerns: Cut on left front paw",
            "Feeding schedule: Twice daily",
            "Animal - Tiger",
            "Name: Maj",
            "Age: 15",
            "Health concerns: None",
            "Feeding schedule: 3x daily",
            "Animal - Bear",
            "Name: Baloo",
            "Age: 1",
            "Health concerns: None",
            "*****Feeding schedule: None on record",
            "Animal - Giraffe",
            "Name: Spots",
            "Age: 12",
            "Health concerns: None",
            "Feeding schedule:",
            "Animal - Wolf",
            "Name: Balto",
            "*****Age: None on record",
            "Health concerns: None",
            "Feeding schedule: 3x daily",
            "Animal - Panda",
            "*****Name: None on record",
            "Age: 2",
            "*****Health concerns: Cut on left ear",
            "Feeding schedule: 5x daily"
    ));
    private static final List<String> EXPECTED_HABITAT_FILE = new ArrayList<>(Arrays.asList(
            "Details on penguin habitat",
            "Details on bird house",
            "Details on aquarium",
            "Details on koala habitat",
            "Habitat - Penguin",
            "Temperature: Freezing",
            "*****Food source: Fish in water running low",
            "Cleanliness: Passed",
            "Habitat - Bird",
            "Temperature: Moderate",
            "Food source: Natural from environment",
            "Cleanliness: Passed",
            "Habitat - Aquarium",
            "Temperature: Varies with output temperature",
            "Food source: Added daily",
            "*****Cleanliness: Needs cleaning from algae",
            "Habitat - Koala",
            "Temperature: Varies with outside temperature",
            "*****Food source: None on record",
            "*****Cleanliness: Needs cleaning from visitor trash"
    ));
    private static final List<Animal> EXPECTED_ANIMAL_LIST = new ArrayList<>(Arrays.asList(
            new Animal("Lion", "Leo", "5", "ALERT - Cut on left front paw - ALERT", "Twice daily"),
            new Animal("Tiger", "Maj", "15", "None", "3x daily"),
            new Animal("Bear", "Baloo", "1", "None", "ALERT - None on record - ALERT"),
            new Animal("Giraffe", "Spots", "12", "None", "ALERT - No Information Provided - ALERT"),
            new Animal("Wolf", "Balto", "ALERT - None on record - ALERT", "None", "3x daily"),
            new Animal("Panda", "ALERT - None on record - ALERT", "2", "ALERT - Cut on left ear - ALERT", "5x daily")
    ));
    private static final List<Habitat> EXPECTED_HABITAT_LIST = new ArrayList<>(Arrays.asList(
            new Habitat("Penguin", "Freezing", "ALERT - Fish in water running low - ALERT", "Passed"),
            new Habitat("Bird", "Moderate", "Natural from environment", "Passed"),
            new Habitat("Aquarium", "Varies with output temperature", "Added daily", "ALERT - Needs cleaning from algae - ALERT"),
            new Habitat("Koala", "Varies with outside temperature", "ALERT - None on record - ALERT", "ALERT - Needs cleaning from visitor trash - ALERT")
    ));

    @Test
    public void test_importFile_Animal() throws IOException {
        List<String> animalFile = Parse.importFile(ANIMAL_CHOICE);

        assertEquals(
                "Imported animals.txt should equal: ",
                animalFile,
                EXPECTED_ANIMAL_FILE
        );
    }

    @Test
    public void test_importFile_Habitat() throws IOException {
        List<String> habitatFile = Parse.importFile(HABITAT_CHOICE);

        assertEquals(
                "Imported habitats file should equal: ",
                habitatFile,
                EXPECTED_HABITAT_FILE
        );
    }

    @Test
    public void test_buildMonitorMenu_Animal() throws IOException {
        List<String> expectedOutput = new ArrayList<>(Arrays.asList(
                MONITOR_MENU_TITLE,
                LINE_SEPARATOR,
                EXIT,
                "Details on lions",
                "Details on tigers",
                "Details on bears",
                "Details on giraffes",
                "Details on wolves",
                "Details on pandas")
        );
        List<String> animalFile = Parse.importFile(ANIMAL_CHOICE);
        List<String> animalMenu = Parse.buildMonitorMenu(animalFile);
        assertEquals(
                "test_buildMonitorMenu_Animal",
                animalMenu,
                expectedOutput
        );
    }

    @Test
    public void test_buildMonitorMenu_Habitat() throws IOException {
        List<String> expectedOutput = new ArrayList<>(Arrays.asList(
                MONITOR_MENU_TITLE,
                LINE_SEPARATOR,
                EXIT,
                "Details on penguin habitat",
                "Details on bird house",
                "Details on aquarium",
                "Details on koala habitat"
        ));
        List<String> habitatFile = Parse.importFile(HABITAT_CHOICE);
        List<String> habitatMenu = Parse.buildMonitorMenu(habitatFile);

        assertEquals(
                "test_buildMonitorMenu_Habitat",
                habitatMenu,
                expectedOutput
        );

    }

    @Test
    public void test_buildAnimalList() throws IOException {
        List<String> animalFile = Parse.importFile(ANIMAL_CHOICE);
        List<Animal> animalList = Parse.buildAnimalList(animalFile);

        for (int i = 0; i < EXPECTED_ANIMAL_LIST.size(); i++) {
            Animal testAnimal = animalList.get(i);
            Animal expectedAnimal = EXPECTED_ANIMAL_LIST.get(i);
            assertEquals(
                    "test_buildAnimalList should contain: ",
                    testAnimal.toString(),
                    expectedAnimal.toString()
            );
        }
    }

    @Test
    public void test_buildHabitatList() throws IOException {
        List<String> habitatFile = Parse.importFile(HABITAT_CHOICE);
        List<Habitat> habitatList = Parse.buildHabitatList(habitatFile);

        for (int i = 0; i < EXPECTED_HABITAT_LIST.size(); i++) {
            Habitat testHabitat = habitatList.get(i);
            Habitat expectedHabitat = EXPECTED_HABITAT_LIST.get(i);
            assertEquals(
                    "test_buildHabitatList should contain: ",
                    testHabitat.toString(),
                    expectedHabitat.toString()
            );
        }
    }
}
