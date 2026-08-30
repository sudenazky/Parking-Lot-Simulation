package SmartParkinglot;

public class CardPayment implements Payment {

    public boolean initiateTransaction(double amount) {
    if(amount>0) {
        System.out.println(amount + "$ successfully charged from the credit card.");
        return true;
    }else{
        System.out.println("Invalid payment amount!");
      return false;
    }

    }
}
