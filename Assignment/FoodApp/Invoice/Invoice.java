package Assignment.FoodApp.Invoice;


import Assignment.FoodApp.Order.Order;

public class Invoice{
    private Order order;
    public Invoice(Order order){
        this.order=order;
    }
    /*calculate final amount by adding tax and deducting discount */
    public double getFinalAmount(){
        double base=order.getTotalAmount();
        double tax=calculateTax(base);
        double discount=calculateDiscount(base);
        return base+tax-discount;

    }
    private double calculateTax(double base){
        return base * 0.18;
    }
    private double calculateDiscount(double base){
        return base*0.05;
    }
}
