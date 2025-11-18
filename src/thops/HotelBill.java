package thops;

import java.util.ArrayList;
import java.util.List;

public class HotelBill {

    static class Order {
        MenuItem item;
        int plates;

        public Order(MenuItem item, int plates) {
            this.item = item;
            this.plates = plates;
        }
    }

    private List<Order> orders = new ArrayList<>();

    public void addOrder(MenuItem item, int plates) {

        // Check if item already exists in bill
        for (Order o : orders) {
            if (o.item.getName().equals(item.getName())) {
                o.plates += plates;  // increase plates
                return;             // do not add duplicate
            }
        }

        // If not found → add new item
        orders.add(new Order(item, plates));
    }

    public void printBill() {
        double total = 0;

        System.out.println("\n-------- FINAL BILL --------");
        System.out.println("Item\tQty\tPrice\tTotal");

        for (Order o : orders) {
            double amount = o.plates * o.item.getPrice();
            total += amount;

            System.out.println(o.item.getName() + "\t" + o.plates + "\t" + o.item.getPrice() + "\t" + amount);
        }

        System.out.println("-----------------------------");
        System.out.println("Total Amount: " + total + " Rs");
        System.out.println("-----------------------------");
    }
}
