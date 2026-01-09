package Assignment.FoodApp.Order;

import java.util.List;

import Assignment.FoodApp.RestaurantApp.MenuItem;
import Assignment.FoodApp.RestaurantApp.Restaurant;
import Assignment.FoodApp.UserApp.Customer;

public class Order {

    private double totalAmount;
    private OrderStatus status;
    private Customer customer;
    private Restaurant restaurant;
    private List<MenuItem> items;

    public Order(Customer customer, Restaurant restaurant, List<MenuItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.status = OrderStatus.CREATED;

        calculateTotal();
    }
    /*calcualate Total amount */
    private void calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
    }
        this.totalAmount = total;
    }
    /*return Order Status */
    public OrderStatus getStatus() {
        return status;
    }
    /*return Total amount */
    public double getTotalAmount() {
        return totalAmount;
    }
    /*confirms order */
    public void confirm() {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException("Only CREATED orders can be confirmed");
        }
        status = OrderStatus.CONFIRMED;
    }
    /*Mark order paid is amount paid */
    public void markPaid() {
        if (status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException("Order must be CONFIRMED before payment");
        }
        status = OrderStatus.PAID;
    }
    /*Set order status to assigned  */
    public void assign() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException("Order must be PAID before assignment");
        }
        status = OrderStatus.ASSIGNED;
    }
    /*set order status to delivered */
    public void deliver() {
        if (status != OrderStatus.ASSIGNED) {
            throw new IllegalStateException("Order must be ASSIGNED before delivery");
        }
        status = OrderStatus.DELIVERED;
    }
}