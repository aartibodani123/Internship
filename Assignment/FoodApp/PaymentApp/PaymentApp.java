package Assignment.FoodApp.PaymentApp;

public class PaymentApp {

    public static void main(String[] args) {

        PaymentMethod payment;

        payment = new UpiPayment("aarti@upi");
        payment.pay(500);

        payment = new CardPayment("1234-5678-9012");
        payment.pay(1200);

        payment = new CashPayment();
        payment.pay(300);
    }
}
