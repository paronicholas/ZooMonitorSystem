package system;

import static helper.MonitorSystemOutputStatic.CHOOSE_MONITOR_OPTION;
import static helper.MonitorSystemOutputStatic.EXIT;
import static helper.MonitorSystemOutputStatic.OPTION_NOT_AVAILABLE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import helper.Parse;
import menu.MonitorMenu;
import monitor.Animal;
import monitor.Habitat;

/**
 * Starts the monitor menu of the monitor system
 */
public class MonitorSystem {
    /**
     *
     * @param input - user input from main menu to choose animal or habitat monitor
     * @throws InterruptedException timeout for re-rendering menu if incorrect number input
     * @throws IOException for input file stream in Parser class
     */
    public static void startMonitor(int input) throws InterruptedException, IOException {
        List<String> parsedFile = Parse.importFile(input);
        List<String> monitorMenu = Parse.buildMonitorMenu(parsedFile);
        List<Animal> animalList = new ArrayList<>();
        List<Habitat> habitatList = new ArrayList<>();

        if (input == 1) {
            animalList = Parse.buildAnimalList(parsedFile);
        } else {
            habitatList = Parse.buildHabitatList(parsedFile);
        }

        monitor(input, monitorMenu, animalList, habitatList);
    }

    /**
     *
     * @param input - user input to render correct monitor menu
     * @param monitorMenu - menu to display on the screen
     * @param animalList - list of Animal Objects
     * @param habitatList - list of Habitat Objects
     * @throws InterruptedException timeout for re-rendering menu if incorrect number input
     */
    private static void monitor(
            int input,
            List<String> monitorMenu,
            List<Animal> animalList,
            List<Habitat> habitatList) throws InterruptedException {
        MonitorMenu menu = new MonitorMenu(monitorMenu);
        Scanner scanner = new Scanner(System.in);
        boolean isContinueMonitoring = true;
        int userInput;

        while (isContinueMonitoring) {
            menu.displayMenu();

            System.out.println(CHOOSE_MONITOR_OPTION);
            userInput = scanner.nextInt();

            if (userInput == 0) {
                System.out.println(EXIT);
                isContinueMonitoring = false;
            } else if (userInput >= 1 && userInput <= menu.getSize() - 3) {
                if (input == 1) {
                    menu.displayAnimalOption(userInput, animalList);
                } else {
                    menu.displayHabitatOption(userInput, habitatList);
                }
                TimeUnit.SECONDS.sleep(5);
            } else {
                System.out.println(OPTION_NOT_AVAILABLE);
            }
        }
    }
}
