package SmartParkinglot;

public class CashPayment implements Payment {

    public boolean initiateTransaction(double amount) {
        if(amount>0) {
            System.out.println(amount + "$ cash payment accepted.");
            return true;
        }else{
            System.out.println("Invalid payment amount!");
            return false;
        }

    }
}
