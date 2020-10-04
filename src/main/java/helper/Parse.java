package helper;

import static helper.MonitorSystemOutputStatic.ANIMAL_PROPERTY_HEADER_LIST;
import static helper.MonitorSystemOutputStatic.ANIMAL_TEXT_PATH;
import static helper.MonitorSystemOutputStatic.HABITAT_PROPERTY_HEADER_LIST;
import static helper.MonitorSystemOutputStatic.HABITAT_TEXT_PATH;
import static helper.MonitorSystemOutputStatic.MONITOR_MENU;
import static helper.MonitorSystemOutputStatic.NO_INFORMATION_PROVIDED;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import monitor.Animal;
import monitor.Habitat;

/**
 * Parsing class which imports either the animal or habitat text file,
 * generates the menu choices for the animal or habitat monitor menus,
 * and generates the list of animal or habitat objects to render when option is chosen
 */
public class Parse {
    /**
     *
     * @param userChoice - user input for menu choice
     * @return parsed animal or habitat file
     * @throws IOException for input file stream
     */
    public static List<String> importFile(int userChoice) throws IOException {
        List<String> importFileList = new ArrayList<>();
        FileInputStream fileInputStream = userChoice == 1 ?
                new FileInputStream(ANIMAL_TEXT_PATH) : new FileInputStream(HABITAT_TEXT_PATH);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String inputFileLine = scanner.nextLine();
            importFileList.add(inputFileLine);
        }

        importFileList.removeAll(Collections.singletonList(""));
        fileInputStream.close();

        return importFileList;
    }

    /**
     *
     * @param parsedFile - imported animal or habitat file
     * @return complete menu option for the animal or habitat monitor menu
     */
    public static List<String> buildMonitorMenu(List<String> parsedFile) {
        List<String> menu = new ArrayList<>(MONITOR_MENU);

        for (String line : parsedFile) {
            if (line.contains("Details on")) {
                menu.add(line);
            }
        }

        return menu;
    }

    /**
     *
     * @param parsedFile - imported animal file
     * @return list of animal objects for animal monitor menu
     */
    public static List<Animal> buildAnimalList(List<String> parsedFile) {
        List<Animal> animalList = new ArrayList<>();
        int startingIndex = setStartingIndex(parsedFile);
        List<List<String>> objectPropertyList =
                    setObjectPropertyListValues(parsedFile, ANIMAL_PROPERTY_HEADER_LIST, startingIndex);

        // add the corresponding properties of each animal to an Animal object
        // and add to the list of Animal objects
        for (int i = 0; i < objectPropertyList.get(0).size(); i++) {
            animalList.add(new Animal(
                    formatString(objectPropertyList.get(0).get(i)),
                    formatString(objectPropertyList.get(1).get(i)),
                    formatString(objectPropertyList.get(2).get(i)),
                    formatString(objectPropertyList.get(3).get(i)),
                    formatString(objectPropertyList.get(4).get(i)))
            );
        }

        return animalList;
    }

    /**
     *
     * @param parsedFile - imported habitat file
     * @return List of habitat objects for habitat monitor menu
     */
    public static List<Habitat> buildHabitatList(List<String> parsedFile) {
        List<Habitat> habitatList = new ArrayList<>();
        int startingIndex = setStartingIndex(parsedFile);
        List<List<String>> objectPropertyList =
                    setObjectPropertyListValues(parsedFile, HABITAT_PROPERTY_HEADER_LIST, startingIndex);

        // add the corresponding properties of each habitat to a Habitat object
        // and add to the list of Habitat objects
        for (int i = 0; i < objectPropertyList.get(0).size(); i++) {
            habitatList.add(new Habitat(
                    formatString(objectPropertyList.get(0).get(i)),
                    formatString(objectPropertyList.get(1).get(i)),
                    formatString(objectPropertyList.get(2).get(i)),
                    formatString(objectPropertyList.get(3).get(i)))
            );
        }

        return habitatList;
    }

    /**
     *
     * @param parsedFile - imported animal or habitat file
     * @return index of first non-menu option in the parsed file
     */
    private static int setStartingIndex(List<String> parsedFile) {
        int startingIndex = 0;
        for (int i = 0; i < parsedFile.size(); i++) {
            if (parsedFile.get(i).contains("Habitat -")) {
                startingIndex = i;
                break;
            }
        }

        return startingIndex;
    }

    /**
     *
     * @param parsedFile - imported animal or habitat file
     * @param propertyTitleList - list of the headers for each animal or habitat object property
     * @param startingIndex - index of first non-menu option in the parsed file
     * @return list of string lists containing all of the elements to build the animal or habitat objects
     */
    private static List<List<String>> setObjectPropertyListValues(
                List<String> parsedFile,
                List<String> propertyTitleList,
                int startingIndex) {
        List<List<String>> objectPropertyList = generateObjectPropertyList(propertyTitleList.size());

        for (int i = startingIndex; i < parsedFile.size(); i++) {
            for (int j = 0; j < propertyTitleList.size(); j++) {
                if (parsedFile.get(i).contains(propertyTitleList.get(j))) {
                    objectPropertyList.get(j).add(parsedFile.get(i));
                    break;
                }
            }
        }

        return objectPropertyList;
    }

    /**
     *
     * @param propertyTitleListLength - number of elements in the property title list
     * @return a list of empty String lists for each property of the animal or habitat
     */
    private static List<List<String>> generateObjectPropertyList(int propertyTitleListLength) {
        List<List<String>> objectPropertyList = new ArrayList<>();
        for (int i = 0; i < propertyTitleListLength; i++) {
            objectPropertyList.add(new ArrayList<>());
        }

        return objectPropertyList;
    }

    /**
     *
     * @param line - text line from the parsed file
     * @return formatted line without header information
     */
    private static String formatString(String line) {
        boolean alert = line.contains("*****");

        if (line.contains("-")) {
            line = isInformationMissing(line) ? NO_INFORMATION_PROVIDED : line.substring(line.indexOf("-") + 2);
        } else if (line.contains(":")) {
            line = isInformationMissing(line) ? NO_INFORMATION_PROVIDED : line.substring(line.indexOf(":") + 2);
        }

        if (alert || line.equals(NO_INFORMATION_PROVIDED)) {
            line = String.format("ALERT - %s - ALERT", line);
        }

        return line;
    }

    /**
     *
     * @param line - text line from the parsed file
     * @return true if information missing; false if information not missing
     */
    private static boolean isInformationMissing(String line) {
        char lastCharOfLine = line.charAt(line.length() - 1);
        return lastCharOfLine == '-' || lastCharOfLine == ':' || lastCharOfLine == ' ';
    }
}
