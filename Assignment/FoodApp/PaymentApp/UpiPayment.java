package Assignment.FoodApp.PaymentApp;

public class UpiPayment implements PaymentMethod {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
        return true;
    }
}
