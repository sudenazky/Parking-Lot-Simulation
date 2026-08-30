package SmartParkinglot;

public class LargeVehicleZone extends ParkingLot {

    public LargeVehicleZone(String name, double hourlyRate, int capacity) {
        super(name, hourlyRate, capacity);
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.TRUCK;
    }
}