import java.io.*;
import java.util.*;

class MenuItem {
    int id;
    String name;
    double price;
    String category;

    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

class MenuManager {
    List<MenuItem> menu = new ArrayList<>();

    void addItem(int id, String name, double price, String category) {
        menu.add(new MenuItem(id, name, price, category));
        System.out.println("Item added.");
    }

    void display() {
        System.out.println("\n--- MENU ITEMS ---");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println("ID: " + item.id + ", Name: " + item.name + ", Price: " + item.price + ", Category: " + item.category);
        }
    }

    MenuItem find(int id) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            if (item.id == id) return item;
        }
        return null;
    }

    void updateItem(int id, String name, double price, String category) {
        MenuItem item = find(id);
        if (item != null) {
            item.name = name;
            item.price = price;
            item.category = category;
            System.out.println("Item updated.");
        } else {
            System.out.println("Item not found.");
        }
    }

    void deleteItem(int id) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).id == id) {
                menu.remove(i);
                System.out.println("Item deleted.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    void saveMenu() throws IOException {
        FileWriter writer = new FileWriter("menu.txt");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            writer.write("ID:" + item.id + ",Name:" + item.name + ",Price:" + item.price + ",Category:" + item.category + "\n");
        }
        writer.close();
        System.out.println("Menu saved.");
    }
}

public class FoodOrderManagementSystem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MenuManager menuManager = new MenuManager();

        while (true) {
            System.out.println("\n1. Add Menu Item\n2. View Menu\n3. Update Menu Item\n4. Delete Menu Item\n5. Save & Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); 
            if (ch == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("Category: ");
                String category = sc.nextLine();
                menuManager.addItem(id, name, price, category);
            } else if (ch == 2) {
                menuManager.display();
            } else if (ch == 3) {
                System.out.print("ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("New Name: ");
                String name = sc.nextLine();
                System.out.print("New Price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("New Category: ");
                String category = sc.nextLine();
                menuManager.updateItem(id, name, price, category);
            } else if (ch == 4) {
                System.out.print("ID to delete: ");
                int id = sc.nextInt();
                menuManager.deleteItem(id);
            } else if (ch == 5) {
                menuManager.saveMenu();
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
