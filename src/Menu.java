public class Menu extends Category{
    public int price;

    public Menu(int index, String name, String description, int price) {
        super(index, name, description);
        this.price = price;
    }

    public void print() {
        System.out.printf("%d. %-20s |  ₩ %-4.1f | %s", this.index, this.name, (double) this.price/1000, this.description);
        System.out.println();
    }

    public void printToCart() {
        System.out.printf("%-25s |  ₩ %-4.1f | %s", this.name, (double) this.price/1000, this.description);
        System.out.println();
    }
}
