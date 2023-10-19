import java.util.HashMap;
import java.util.Map;

public class Cart {
    public Map<Menu, Integer> menus;

    public Cart() {
        this.menus = new HashMap<>();
    }

    public void addMenu(Menu menu) {
        menus.put(menu, menus.getOrDefault(menu, 0) + 1);
    }

    public void getTotalPrice() {
        double price = 0;

        for (Menu menu : menus.keySet()) {
            price += menu.price * menus.get(menu);
        }

        price /= 1000;
        System.out.printf("₩ %.1f\n\n", price);
    }

    public void printMenus() {
        for (Menu menu : this.menus.keySet()) {
            menu.printToCartWithCount(menus.get(menu));
        }
    }

    public void clear() {
        this.menus = new HashMap<>();
    }
}
