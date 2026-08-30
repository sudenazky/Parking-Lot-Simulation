package SmartParkinglot;

import java.time.LocalDateTime;
import java.util.UUID;
import java.time.Duration;

public class ParkingTicket {
    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_PAID = "PAID";

    private final String ticketNumber;
    private final Vehicle vehicle;
    private final ParkingLot parkingLot;
    private final LocalDateTime entryTime;
    private LocalDateTime paidAt;
    private double amount;
    private String status;

    public ParkingTicket(Vehicle vehicle, ParkingLot parkingLot) {
        this.ticketNumber = "TICK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.vehicle = vehicle;
        this.parkingLot = parkingLot;
        this.entryTime = LocalDateTime.now();
        this.status = STATUS_ACTIVE;
        this.amount = 0.0;
    }

    public void calculateFee(double baseHourlyRate) {
        long hoursParked=Duration.between(entryTime,LocalDateTime.now()).toHours();
        if (hoursParked==0) {
            hoursParked=1;
        }
        double multiplier = vehicle.getVehicleType().getFeeMultiplier();
        this.amount = baseHourlyRate * multiplier * hoursParked;
    }

    public void markAsPaid() {
        this.status = STATUS_PAID;
        this.paidAt = LocalDateTime.now();
    }
    public String getOwnerName() {
        return vehicle.getOwner().getName();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}