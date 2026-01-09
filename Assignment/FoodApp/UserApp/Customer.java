package Assignment.FoodApp.UserApp;

public class Customer extends User {

    public Customer(long id, String name, String phone) {
        super(id, name, phone);
    }

    public void placeOrder() {
        System.out.println(name + " placed an order");
    }
}
