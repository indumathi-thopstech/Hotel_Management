package thops;

import java.util.*;

public class HotelApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("  Welcome to Thops Hotel 😊");
        System.out.println("=====================================");

        // ----- Categories -----
        MenuCategory veg = new MenuCategory("Veg");
        veg.addItem(new MenuItem("Poori", 3, 40));
        veg.addItem(new MenuItem("Idly", 2, 30));
        veg.addItem(new MenuItem("Dosa", 1, 50));
        veg.addItem(new MenuItem("Meals", 1, 90));
        veg.addItem(new MenuItem("Chapathi", 2, 45));
        veg.addItem(new MenuItem("Pongal", 1, 55));
        veg.addItem(new MenuItem("Vada", 2, 35));

        MenuCategory nonVeg = new MenuCategory("Non-Veg");
        nonVeg.addItem(new MenuItem("Chicken Biryani", 1, 150));
        nonVeg.addItem(new MenuItem("Mutton Biryani", 1, 220));
        nonVeg.addItem(new MenuItem("Grill Chicken", 1, 180));
        nonVeg.addItem(new MenuItem("Chicken Fry", 1, 120));
        nonVeg.addItem(new MenuItem("Fish Fry", 1, 140));
        nonVeg.addItem(new MenuItem("Prawn Curry", 1, 200));
        nonVeg.addItem(new MenuItem("Egg Curry", 1, 80));

        MenuCategory snacks = new MenuCategory("Snacks");
        snacks.addItem(new MenuItem("Samosa", 2, 25));
        snacks.addItem(new MenuItem("Puffs", 1, 20));
        snacks.addItem(new MenuItem("Cutlet", 1, 30));
        snacks.addItem(new MenuItem("French Fries", 1, 60));
        snacks.addItem(new MenuItem("Sandwich", 1, 70));
        snacks.addItem(new MenuItem("Rolls", 1, 50));
        snacks.addItem(new MenuItem("Bajji", 3, 35));

        MenuCategory drinks = new MenuCategory("Cool Drinks");
        drinks.addItem(new MenuItem("Coke", 1, 40));
        drinks.addItem(new MenuItem("Sprite", 1, 40));
        drinks.addItem(new MenuItem("Pepsi", 1, 40));
        drinks.addItem(new MenuItem("Fanta", 1, 40));
        drinks.addItem(new MenuItem("Maaza", 1, 35));
        drinks.addItem(new MenuItem("Lassi", 1, 50));
        drinks.addItem(new MenuItem("Juice", 1, 60));

        // All categories list
        List<MenuCategory> categories = Arrays.asList(veg, nonVeg, snacks, drinks);

        HotelBill bill = new HotelBill();
        char cont='Y';

        do {
            System.out.println("\n------ Main Menu ------");
            System.out.println("1. Veg");
            System.out.println("2. Non-Veg");
            System.out.println("3. Snacks");
            System.out.println("4. Cool Drinks");
            System.out.print("Select option: ");

            int choice = sc.nextInt();

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice!");
                continue;
            }

            MenuCategory selectedCategory = categories.get(choice - 1);
            selectedCategory.displayItems();

            System.out.print("Select item: ");
            int itemChoice = sc.nextInt();

            if (itemChoice < 1 || itemChoice > 7) {
                System.out.println("Invalid item!");
                continue;
            }

            MenuItem selectedItem = selectedCategory.getItems().get(itemChoice - 1);

            System.out.print("How many plates?: ");
            int plates = sc.nextInt();

            bill.addOrder(selectedItem, plates);

            System.out.print("Do you want to continue? (Y/N): ");
            cont = sc.next().charAt(0);

        } while (cont == 'Y' || cont == 'y');

        // Show final bill
        bill.printBill();

        // Rating
        System.out.print("\nPlease rate our service (1 to 5 stars): ");
        int rating = sc.nextInt();

        System.out.print("Write your feedback: ");
        sc.nextLine();  
        String review = sc.nextLine();

        System.out.println("\nThank you for your review! ⭐" + rating);
        System.out.println("Your Feedback: " + review);
        System.out.println("Visit Again! ❤");
    }
}
