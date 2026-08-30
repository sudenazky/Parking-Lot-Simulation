package SmartParkinglot;

public class Motorcycle extends Vehicle {
    private final int engineCapacity;

    public Motorcycle(String name, String licensePlate, User owner, int engineCapacity) {
        super(name, licensePlate, VehicleType.MOTORCYCLE, owner);

        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0 cc!");
        }
        this.engineCapacity = engineCapacity;
    }

    public Motorcycle(String name, String licensePlate, User owner) {
        this(name, licensePlate, owner, 125);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Engine Capacity : " + engineCapacity + " cc");
    }
}