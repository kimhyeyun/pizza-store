import java.util.Map;

public class Menu extends Category{
    public int price;

    public Menu(int index, String name, String description, int price) {
        super(index, name, description);
        this.price = price;
    }
}
