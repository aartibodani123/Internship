// FoodieExpress - JPA Relationship Examples (Spring Boot + Hibernate)
// Package: com.foodieexpress.model

import jakarta.persistence.*;
import java.util.*;

// 1. ONE TO ONE: Customer <-> CustomerProfile
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;
    private String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerProfile profile;
}

@Entity
@Table(name = "customer_profiles")
class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

// 2. ONE TO MANY: Customer -> Orders
@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")n    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}

// 3. ONE TO MANY: Restaurant -> MenuItems
@Entity
@Table(name = "restaurants")
class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    private String name;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems = new ArrayList<>();
}

@Entity
@Table(name = "menu_items")
class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}

// 4. MANY TO MANY via Join Table: Orders <-> MenuItems
@Entity
@Table(name = "order_items")
class OrderItem {
    @EmbeddedId
    private OrderItemKey id = new OrderItemKey();

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private MenuItem menuItem;

    private int quantity;
}

@Embeddable
class OrderItemKey implements java.io.Serializable {
    private Long orderId;
    private Long itemId;
}
