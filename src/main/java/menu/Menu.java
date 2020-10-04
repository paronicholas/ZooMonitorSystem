package menu;

import java.util.List;

/**
 * Menu parent class
 */
public class Menu {
    private List<String> menu;

    public Menu(List<String> menu) {
        this.menu = menu;
    }

    /**
     * Display menu options
     */
    public void displayMenu() {
        System.out.println(menu.get(0));
        System.out.println(menu.get(1));
        for (int i = 2; i < menu.size(); i++) {
            System.out.println(String.format("%d: %s", i-2, menu.get(i)));
        }
    }
}
