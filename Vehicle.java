package SmartParkinglot;

public abstract class Vehicle {
    private String name;
    private final String licensePlate;
    private final VehicleType vehicleType;
    private final User owner;

    public Vehicle(String name, String licensePlate, VehicleType vehicleType, User owner) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public User getOwner() {
        return owner;
    }

    public void showInfo() {
        System.out.println("Driver Name   : " + owner.getName());
        System.out.println("Vehicle Name  : " + name);
        System.out.println("License Plate : " + licensePlate);
        System.out.println("Vehicle Type  : " + vehicleType);
    }
}