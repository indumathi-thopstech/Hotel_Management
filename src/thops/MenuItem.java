package thops;

public class MenuItem {
    private String name;
    private int quantity;   // default quantity of the item (ex: poori (3))
    private double price;   // cost

    public MenuItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
