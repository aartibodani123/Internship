

package Assignment.FoodApp.service;

import Assignment.FoodApp.Delivery.DeliveryPartner;
import Assignment.FoodApp.Order.*;

public class DeliveryService {

    public void assignDeliveryPartner(Order order, DeliveryPartner partner) {

        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException("Order must be PAID before assignment");
        }

        if (!partner.isAvailable()) {
            throw new IllegalStateException("Delivery partner is not available");
        }

        partner.assignOrder();
        order.assign();

        System.out.println("Order assigned to delivery partner: " + partner.getName());
    }

    public void markDelivered(Order order, DeliveryPartner partner) {

        if (order.getStatus() != OrderStatus.ASSIGNED) {
            throw new IllegalStateException("Order must be ASSIGNED before delivery");
        }

        order.deliver();
        partner.markDelivered();

        System.out.println("Order delivered successfully");
    }
}

