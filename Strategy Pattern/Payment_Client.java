interface Payment {
    void pay(int amount);
}

class UpiPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("UPI payment :: " + amount);
    }
}

class CardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Card payment :: " + amount);
    }
}

class NetBankingPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("NetBanking payment :: " + amount);
    }
}

class PaymentSystem {
    private Payment payment;

    void setPayment(Payment payment) {
        this.payment = payment;
    }

    void doPayment(int amount) {
        payment.pay(amount);
    }
}

class Payment_Client {
    public static void main(String[] args) {

        System.out.println("Welcome to Payment System for Strategy Pattern");

        PaymentSystem paymentSystem = new PaymentSystem();

        Payment upiPayment = new UpiPayment();
        Payment cardPayment = new CardPayment();
        Payment netBankingPayment = new NetBankingPayment();

        paymentSystem.setPayment(upiPayment);
        paymentSystem.doPayment(50);
    }
}
