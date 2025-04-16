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
