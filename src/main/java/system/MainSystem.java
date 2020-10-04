package system;

import static helper.MonitorSystemOutputStatic.CHOOSE_MONITOR_OPTION;
import static helper.MonitorSystemOutputStatic.EXIT_MONITOR;
import static helper.MonitorSystemOutputStatic.MAIN_MENU;
import static helper.MonitorSystemOutputStatic.OPTION_NOT_AVAILABLE;
import static helper.MonitorSystemOutputStatic.SYSTEM_NAME;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import menu.MainMenu;
import menu.Menu;

/**
 * Starts the main menu of the monitor system
 */
public class MainSystem {
    /**
     *
     * @throws InterruptedException timeout for re-rendering menu if incorrect number input
     * @throws IOException for input file stream in Parser class
     */
    public static void startMonitor() throws Exception {
        Menu mainMenu = new MainMenu(MAIN_MENU);
        Scanner scanner = new Scanner(System.in);
        boolean isContinueMonitoring = true;
        int userInput;

        while(isContinueMonitoring) {
            System.out.println(SYSTEM_NAME);
            mainMenu.displayMenu();

            System.out.println(CHOOSE_MONITOR_OPTION);
            userInput = scanner.nextInt();

            if (userInput == 0) {
                System.out.println(EXIT_MONITOR);
                isContinueMonitoring = false;
            } else if (userInput == 1 || userInput == 2) {
                MonitorSystem.startMonitor(userInput);
            } else {
                System.out.println(OPTION_NOT_AVAILABLE);
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }
}
