import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

    public List<Menu> menus;
    public double totalPrice;

    public Order() {
        this.menus = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addMenu(Map<Menu, Integer> menus) {
        for (Menu key : menus.keySet()) {
            for (int i = 0; i < menus.get(key); i++) {
                this.menus.add(key);
                this.totalPrice += key.price;
            }
        }
    }

    public void printMenu() {
        for (Menu menu : this.menus) {
            System.out.printf("- %-30s | ₩ %.1f\n", menu.name, menu.price / 1000);
        }
    }
}
