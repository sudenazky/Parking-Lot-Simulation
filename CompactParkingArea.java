package SmartParkinglot;

public class CompactParkingArea extends ParkingLot {

    public CompactParkingArea(String name, double hourlyRate, int capacity) {
        super(name, hourlyRate, capacity);
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.CAR;
    }
}