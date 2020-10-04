package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonitorSystemOutputStatic {
    // Main System
    public static final String SYSTEM_NAME = "\nZoo Monitoring System";
    public static final String EXIT_MONITOR = "\nExit Zoo Monitoring System";
    public static final String CHOOSE_MONITOR_OPTION = "\nChoose a monitoring option (number): ";
    public static final String OPTION_NOT_AVAILABLE = "\nMonitoring option is not available";

    // Menu
    public static final String LINE_SEPARATOR = "------------------------------";
    public static final String EXIT = "Exit";

    // Main Menu
    public static final String MAIN_MENU_TITLE = "\nMain Menu";
    public static final String MONITOR_ANIMAL = "Animal Monitor Menu";
    public static final String MONITOR_HABITAT = "Habitat Monitor Menu";
    public static final List<String> MAIN_MENU = new ArrayList<>(
        Arrays.asList(MAIN_MENU_TITLE, LINE_SEPARATOR, EXIT, MONITOR_ANIMAL, MONITOR_HABITAT)
    );

    // Monitor Menu
    public static final String MONITOR_MENU_TITLE = "\nMonitor Menu";
    public static List<String> MONITOR_MENU = new ArrayList<>(
        Arrays.asList(MONITOR_MENU_TITLE, LINE_SEPARATOR, EXIT)
    );
    public static final List<String> ANIMAL_PROPERTY_HEADER_LIST = new ArrayList<>(
        Arrays.asList("Animal -", "Name:", "Age:", "Health concerns:", "Feeding schedule:")
    );
    public static final List<String> HABITAT_PROPERTY_HEADER_LIST = new ArrayList<>(
        Arrays.asList("Habitat -", "Temperature:", "Food source:", "Cleanliness:")
    );
    public static final String NO_INFORMATION_PROVIDED = "No Information Provided";

    // Parser
    public static final String ANIMAL_TEXT_PATH = "src/main/java/text/animals.txt";
    public static final String HABITAT_TEXT_PATH = "src/main/java/text/habitats.txt";
}
