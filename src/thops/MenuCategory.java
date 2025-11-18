package thops;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory {
    private String name;
    private List<MenuItem> items;

    public MenuCategory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void displayItems() {
        System.out.println("------ " + name + " Menu ------");
        int i = 1;
        for (MenuItem item : items) {
            System.out.println(i + ". " + item.getName() + " (" + item.getQuantity() + ") --> " + item.getPrice() + " Rs");
            i++;
        }
    }
}
