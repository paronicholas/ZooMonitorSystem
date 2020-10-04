import java.io.IOException;
import java.util.*;

public class Monitors {
    private int mainMenuOptionValue;
    private int optionChoice;
    private int userMonitorChoice;
    private int monitorMenuLength;
    private int continueMonitoring;

    void setMonitoringOption(int userInput) {
        mainMenuOptionValue = userInput;
    }

    int getMonitoringOption() {
        return mainMenuOptionValue;
    }

    void monitorShell() throws IOException {
        Menus menus = new Menus();
        Parsers file = new Parsers();
        Scanner scnr = new Scanner(System.in);
        List<String> monitorMenuItems;
        List<String> parsableList;
        boolean backToMain = false;  // Error handling for menu options if invalid input entered
        boolean repeat = false;  // Error handling for continueMonitoring option after monitor chosen

        while (!backToMain) {
            parsableList = file.fileReader(getMonitoringOption());
            optionChoice = getMonitoringOption();  // Sets the monitor to animals or habitats based on user input

            menus.monitorMenu(optionChoice);
            monitorMenuItems = menus.monitorMenuList(parsableList);
            System.out.print("Choose a monitoring option (number): ");
            userMonitorChoice = scnr.nextInt();
            System.out.println("\n");

            monitorMenuLength = monitorMenuItems.size();  // Allows for scalability if new item added to .txt files

            if (userMonitorChoice == 0) {
                backToMain = true;
            }
            else if ((userMonitorChoice >= 1) && (userMonitorChoice <= monitorMenuLength)) {
                // parsableList called with monitor menu items removed, allowing printable items to correctly parse
                file.monitorInfoParser(parsableList, userMonitorChoice, optionChoice);
                while (!repeat) {  // Handles error if user enters invalid number
                    System.out.print("Continue monitoring (1: Monitor Menu or 2: Main Menu): ");
                    continueMonitoring = scnr.nextInt();
                    System.out.println("\n");
                    switch (continueMonitoring) {
                        case 1:
                            backToMain = false;
                            repeat = true;
                            break;
                        case 2:
                            backToMain = true;
                            repeat = true;
                            break;
                        default:
                            System.out.println("Not a valid option.\n\n");
                    }
                }
                repeat = false;
            }
            else {
                System.out.println("Monitoring option not available.\n\n");
                backToMain = false;
            }
        }
    }
}
