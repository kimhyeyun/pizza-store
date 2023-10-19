public class Menu extends Category{
    public int price;

    public Menu(int index, String name, String description, int price) {
        super(index, name, description);
        this.price = price;
    }

    public void print() {
        System.out.printf("%d. %-20s |  ₩ %-4.1f | %s\n", this.index, this.name, (double) this.price/1000, this.description);
    }

    public void printToCart() {
        System.out.printf("%-25s |  ₩ %-4.1f | %s\n", this.name, (double) this.price/1000, this.description);
    }

    public void printToCartWithCount(int count) {
        System.out.printf("%-25s |  ₩ %-4.1f | %d개 | %s\n", this.name, (double) this.price / 1000, count, this.description);
    }
}
