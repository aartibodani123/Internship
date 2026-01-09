package Assignment.FoodApp.Main;

import java.util.*;


import Assignment.FoodApp.UserApp.*;
import Assignment.FoodApp.Delivery.DeliveryPartner;
import Assignment.FoodApp.Invoice.Invoice;
import Assignment.FoodApp.Order.Order;
import Assignment.FoodApp.RestaurantApp.MenuItem;
import Assignment.FoodApp.RestaurantApp.Restaurant;
import Assignment.FoodApp.service.DeliveryService;
import Assignment.FoodApp.service.InvoiceService;
import Assignment.FoodApp.service.RestaurantService;
import Assignment.FoodApp.service.UserService;


public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // ---------- SIGNUP ----------
            System.out.println("Enter email:");
            String email = sc.nextLine();

            System.out.println("Enter password:");
            String password = sc.nextLine();

            Customer customer = new Customer(1, "Aarti", "9999999999");
            UserService.signUp(email, password, customer);

            // ---------- LOGIN ----------
            System.out.println("Login email:");
            String loginEmail = sc.nextLine();

            System.out.println("Login password:");
            String loginPassword = sc.nextLine();

            User loggedInUser = UserService.signIn(loginEmail, loginPassword);

            if (!(loggedInUser instanceof Customer)) {
                System.out.println("Only customers can place orders");
                return;
            }

            Customer loggedInCustomer = (Customer) loggedInUser;

            // ---------- RESTAURANT ----------
           
            RestaurantService restaurantService = new RestaurantService();

            Restaurant r1 = new Restaurant(1, "Food Hub", "MG Road");
            r1.addMenuItem(new MenuItem(101, "Pizza", 150));
            r1.addMenuItem(new MenuItem(102, "Burger", 100));

            restaurantService.addRestaurant(r1);

            Restaurant r2 = new Restaurant(1, "Mexicano", "MG Road");
            r1.addMenuItem(new MenuItem(101, "Rice Bowl", 300));
            r1.addMenuItem(new MenuItem(102, "Pasta", 500));

            restaurantService.addRestaurant(r2);
            System.out.println("\nAvailable Restaurant:");
            restaurantService.listRestaruant();

            System.out.println("Select restaurant:");
            int choice = sc.nextInt();

            if (choice != 1) {
                System.out.println("Invalid restaurant selection");
                return;
            }

            // ---------- MENU ----------
            restaurant.showMenu();

            System.out.println("Enter item number (1-Pizza, 2-Burger):");
            int itemChoice = sc.nextInt();

            MenuItem selectedItem;
            if (itemChoice == 1) {
                selectedItem = pizza;
            } else if (itemChoice == 2) {
                selectedItem = burger;
            } else {
                System.out.println("Invalid item");
                return;
            }

            // ---------- ORDER ----------
            Order order = new Order(
                    loggedInCustomer,
                    restaurant,
                    Arrays.asList(selectedItem)
            );

            order.confirm();
            System.out.println("Order confirmed");

            // ---------- INVOICE ----------
            InvoiceService invoiceService = new InvoiceService();
            Invoice invoice = invoiceService.generateInvoice(order);

            System.out.println("Please pay: " + invoice.getFinalAmount());

            order.markPaid();

            // ---------- DELIVERY ----------
            DeliveryPartner partner = new DeliveryPartner(101, "Rahul", "983456767");
            DeliveryService deliveryService = new DeliveryService();

            deliveryService.assignDeliveryPartner(order, partner);
            deliveryService.markDelivered(order, partner);

            System.out.println("Order delivered successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
