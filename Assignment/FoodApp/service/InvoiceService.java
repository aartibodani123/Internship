package Assignment.FoodApp.service;

import Assignment.FoodApp.Invoice.Invoice;
import Assignment.FoodApp.Order.Order;

public class InvoiceService {

    public Invoice generateInvoice(Order order) {
        return new Invoice(order);
    }
}
