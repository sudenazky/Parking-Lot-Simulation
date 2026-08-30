package SmartParkinglot;

public class Car extends Vehicle {
    private final boolean isElectric;

    public Car(String name, String licensePlate, User owner, boolean isElectric) {
        super(name, licensePlate, VehicleType.CAR, owner);
        this.isElectric = isElectric;
    }

    public Car(String name, String licensePlate, User owner) {
        this(name, licensePlate, owner, false);
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void showInfo() {
        super.showInfo();
        String electricStatus = isElectric ? "Yes" : "No";
        System.out.println("Is Electric   : " + electricStatus);
    }
}