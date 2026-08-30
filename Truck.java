package SmartParkinglot;

public class Truck extends Vehicle {
    private final double cargoCapacity;

    public Truck(String name, String licensePlate, double cargoCapacity, User owner) {
        super(name, licensePlate, VehicleType.TRUCK, owner);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than 0!");
        }
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Cargo Capacity : " + cargoCapacity + " kg");
    }
}