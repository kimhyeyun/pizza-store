import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Menu> menus;

    public Cart() {
        this.menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public void getTotalPrice() {
        double price = 0;

        for (Menu menu : menus) {
            price += menu.price;
        }

        price /= 1000;
        System.out.printf("₩ %.1f\n\n", price);
    }

    public void printMenus() {
        for (Menu menu : this.menus) {
            menu.printToCart();
        }
    }

    public void clear() {
        this.menus = new ArrayList<>();
    }
}
