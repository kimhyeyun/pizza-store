import java.util.HashMap;
import java.util.Map;

public class Menu extends Category{
    public double price;
    public Map<Integer, Option> options;

    public Menu(int index, String name, String description, double price) {
        super(index, name, description);
        this.price = price;
        options = new HashMap<>();
    }

    public void addOption(int index, String option, double price) {
        this.options.put(index, new Option(option, price));
    }

    public void print() {
        System.out.printf("%d. %-20s |  ₩ %-4.1f | %s\n", this.index, this.name, this.price/1000, this.description);
    }

    public void printToCart() {
        System.out.printf("%-25s |  ₩ %-4.1f | %s\n", this.name, this.price/1000, this.description);
    }

    public void printToCartWithCount(int count) {
        System.out.printf("%-25s |  ₩ %-4.1f | %d개 | %s\n", this.name, this.price / 1000, count, this.description);
    }

    public void printOption() {
        for (int index : options.keySet()) {
            System.out.printf("%d. %s(₩ %.1f)\t\t", index, options.get(index).name, options.get(index).price / 1000);
        }
    }
}
