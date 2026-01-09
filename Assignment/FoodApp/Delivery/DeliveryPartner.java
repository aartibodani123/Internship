package Assignment.FoodApp.Delivery;

import Assignment.FoodApp.UserApp.User;

public class DeliveryPartner extends User {

    private boolean available = true;

    public DeliveryPartner(long id, String name, String phone) {
        super(id, name, phone);
    }
    /*return Availablity status of delivery partner */
    public boolean isAvailable() {
        return available;
    }
    /*assign order to deliverypartner and marks it availablity status to false  */
    public void assignOrder() {
        if (!available) {
            throw new IllegalStateException("Delivery partner not available");
        }
        available = false;
    }

    public void markDelivered() {
      
         available = true;
    }
    /*return of delivery partner */
    public String getName(){
        return name;
    }
}
