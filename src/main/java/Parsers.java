import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Parsers {
    private final String ALERT_CHARACTERS = "*****";
    private String fileString;
    private String alert;
    private int i;
    private int j;

    List<String> fileReader(int monitorChoice) throws IOException {
        FileInputStream fileByteStream = null;
        Scanner inFS = null;
        List<String> parsableList = new ArrayList<>(Collections.emptyList());

        if (monitorChoice == 1) {
            fileByteStream = new FileInputStream("animals.txt");
            inFS = new Scanner(fileByteStream);
        }
        if (monitorChoice == 2) {
            fileByteStream = new FileInputStream("habitats.txt");
            inFS = new Scanner(fileByteStream);
        }

        assert inFS != null;
        fileString = inFS.nextLine();
        parsableList.add(fileString);
        while (inFS.hasNextLine()) {
            fileString = inFS.nextLine();
            parsableList.add(fileString);
        }

        parsableList.removeAll(Collections.singleton(""));

        fileByteStream.close();

        return parsableList;
    }

    void monitorInfoParser(List<String> parsableList, int choiceNumber, int mainMenuOption) {
        List<String> monitorInfoList = new ArrayList<>(Collections.emptyList());
        int[] monitorInfoLength = new int[2];

        monitorInfoLength[0] = 4;  // Length of animal monitor for iteration
        monitorInfoLength[1] = 3;  // Length of habitat monitor for iteration

        // Assigns call variables to user chosen monitor option
        for (i = 0; i < choiceNumber; ++i) {
            for (j = 0; j <= monitorInfoLength[mainMenuOption - 1]; ++j) {
                monitorInfoList.add(parsableList.get(0));
                parsableList.remove(0);
            }
        }

        // Removes parsed monitor information prior to user chosen monitor option
        for (i = 0; i < choiceNumber - 1; ++i) {
            for (j = 0; j <= monitorInfoLength[mainMenuOption - 1]; ++j) {
                monitorInfoList.remove(0);
            }
        }

        System.out.println("------------------------------");

        // Creates alert for out-of-normal information and removes "*" from index string
        for (i = 0; i <= monitorInfoLength[mainMenuOption - 1]; ++i) {
            if (monitorInfoList.get(i).contains(ALERT_CHARACTERS)) {
                alert = monitorInfoList.get(i).replace(ALERT_CHARACTERS, "");
                monitorInfoList.set(i, alert);  // Replaces index string with "*" with same index string without "*"
                System.out.printf("ALERT - %s - ALERT\n\n", alert.toUpperCase());
            }
        }

        for (i = 0; i <= monitorInfoLength[mainMenuOption - 1]; ++i) {
            System.out.println(monitorInfoList.get(i));
        }
        System.out.println("------------------------------\n");
    }
}
