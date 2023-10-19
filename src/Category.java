public class Category {

    public int index;
    public String name;
    public String description;

    public Category(int index, String name, String description) {
        this.index = index;
        this.name = name;
        this.description = description;
    }

    public void print() {
        System.out.printf("%d. %-15s | %s", this.index, this.name, this.description);
        System.out.println();
    }
}
