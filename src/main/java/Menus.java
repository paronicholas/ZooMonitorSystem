import java.util.*;

public class Menus {

    void mainMenu() {
        final int NUM_ELEMENTS = 3;
        int i;
        List<String> mainMenuList = new ArrayList<>(Arrays.asList("Exit", "Monitor Animals", "Monitor Habitats"));

        System.out.println("MAIN MENU");
        System.out.println("------------------------------");
        for (i = 0; i < NUM_ELEMENTS; ++i) {
            System.out.printf("%d: %s\n", i, mainMenuList.get(i));
        }
        System.out.println();
    }

    void monitorMenu(int monitorOptionChoice) {
        List<String> menuTitle = new ArrayList<>(Arrays.asList("ANIMAL MONITOR MENU", "HABITAT MONITOR MENU"));

        System.out.println();
        System.out.println(menuTitle.get(monitorOptionChoice - 1));
        System.out.println("------------------------------");
        System.out.println("0: Return to main menu");
    }

    List<String> monitorMenuList(List<String> parsableList) {
        List<String> monitorMenuOptions = new ArrayList<>(Collections.emptyList());
        int menuLength;
        int i;

        // Add the lines containing "details" from the file list to a new list and remove those items from the file list
        if(parsableList.get(0).contains("Details")) {
            while (parsableList.get(0).contains("Details")) {
                monitorMenuOptions.add(parsableList.get(0));
                parsableList.remove(0);
            }
        }

        menuLength = monitorMenuOptions.size() - 1;

        for (i = 0; i <= menuLength; ++i) {
            System.out.printf("%d: %s\n", i + 1, monitorMenuOptions.get(i));
        }
        System.out.println();

        return monitorMenuOptions;
    }
}
