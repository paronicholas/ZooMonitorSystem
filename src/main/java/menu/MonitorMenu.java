package menu;

import java.util.List;

import monitor.Animal;
import monitor.Habitat;

/**
 * MonitorMenu, child class of Menu
 */
public class MonitorMenu extends Menu {
    private List<String> monitorMenu;

    public MonitorMenu(List<String> monitorMenu) {
        super(monitorMenu);
        this.monitorMenu = monitorMenu;
    }

    public int getSize() {
        return this.monitorMenu.size();
    }

    public void displayAnimalOption(int userInput, List<Animal> animals) {
        Animal animal = animals.get(userInput - 1);
        animal.display();
    }

    public void displayHabitatOption(int userInput, List<Habitat> habitats) {
        Habitat habitat = habitats.get(userInput - 1);
        habitat.display();

    }
}
