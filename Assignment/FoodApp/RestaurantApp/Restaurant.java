package Assignment.FoodApp.RestaurantApp;
import java.util.HashMap;
import java.util.Map;
import Assignment.FoodApp.Exception.*;

public class Restaurant {

    private int id;
    private String name;
    private String address;

    // Menu: itemId -> MenuItem
    private Map<Integer, MenuItem> menu = new HashMap<>();

    public Restaurant(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Add menu item
    public void addMenuItem(MenuItem item) {
        menu.put(item.getId(), item);
    }

    // Get menu item
    public MenuItem getMenuItem(int itemId) {
        if (!menu.containsKey(itemId)) {
            throw new ItemNotAvailableException(
                    "Item with id " + itemId + " not available"
            );
        }
        return menu.get(itemId);
    }

    public Map<Integer, MenuItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}
