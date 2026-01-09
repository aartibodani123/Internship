package Assignment.FoodApp.PaymentApp;

public class CardPayment implements PaymentMethod {

    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card: " + cardNumber);
        return true;
    }
}