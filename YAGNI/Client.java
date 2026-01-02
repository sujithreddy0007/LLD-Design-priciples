package YAGNI;

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid using Credit Card");
    }
}

class UpiPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid using UPI");
    }
}

class CheckoutService {
    public void checkout(PaymentMethod payment, double amount) {
        payment.pay(amount);
    }
}

public class Client {
    public static void main(String[] args) {

        CheckoutService checkout = new CheckoutService();

        checkout.checkout(new CreditCardPayment(), 1500);
        checkout.checkout(new UpiPayment(), 800);
    }
}
