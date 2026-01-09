package Assignment.FoodApp.PaymentApp;

public class CashPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " in Cash");
        return true;
    }
}

