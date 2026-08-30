package SmartParkinglot;

public class MotorcycleLot extends ParkingLot {

    public MotorcycleLot(String name, double hourlyRate, int capacity) {
        super(name, hourlyRate, capacity);
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.MOTORCYCLE;
    }
}