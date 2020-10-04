import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menus menuOptions = new Menus();
        Monitors choice = new Monitors();
        Scanner scnr = new Scanner(System.in);
        int userInput;
        boolean monitorContinue = false;

        System.out.println("ZOO MONITORING SYSTEM\n\n");

        while (!monitorContinue) {
            menuOptions.mainMenu();

            System.out.print("Choose a monitoring option (number): ");
            userInput = scnr.nextInt();
            System.out.println();
            choice.setMonitoringOption(userInput);

            switch (userInput) {
                case 0:
                    System.out.println("EXITING ZOO MONITORING SYSTEM");
                    monitorContinue = true;
                    break;
                case 1:
                case 2:
                    choice.monitorShell();
                    break;
                default:
                    System.out.println("Monitoring option not available\n\n");
                    break;
            }
        }
    }
}
