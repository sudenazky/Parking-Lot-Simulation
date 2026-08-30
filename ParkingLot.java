package SmartParkinglot;

import java.util.HashMap;
import java.util.Map;

public abstract class ParkingLot {
    private String name;
    private double hourlyRate;
    private int capacity;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot(String name, double hourlyRate, int capacity) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.capacity = capacity;
        this.activeTickets = new HashMap<>();
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            System.out.println("Sorry, " + vehicle.getVehicleType() + " (" + vehicle.getLicensePlate() + ") is not suitable for " + name + "!");
            return null;
        }

        if (activeTickets.size() >= capacity) {
            System.out.println("Sorry, " + name + " is completely full!");
            return null;
        }

        ParkingTicket ticket = new ParkingTicket(vehicle, this);
        activeTickets.put(ticket.getTicketNumber(), ticket);

        System.out.println("The vehicle has been successfully parked. Your ticket has been generated.");
        System.out.println("Driver Name: " + ticket.getOwnerName());
        System.out.println("License Plate: " + vehicle.getLicensePlate());
        System.out.println("Ticket No: " + ticket.getTicketNumber());

        return ticket;
    }

    public boolean processExit(String ticketNumber, Payment paymentMethod) {
        ParkingTicket ticket = activeTickets.get(ticketNumber);

        if (ticket == null) {
            System.out.println("Error: Invalid or non-existent ticket number!");
            return false;
        }

        ticket.calculateFee(hourlyRate);

        boolean isPaid = paymentMethod.initiateTransaction(ticket.getAmount());

        if (isPaid) {
            ticket.markAsPaid();
            activeTickets.remove(ticketNumber);
            System.out.println("Vehicle has exited the parking lot.");
            return true;
        } else {
            System.out.println("Payment failed! Exit operation is denied.");
            return false;
        }
    }

    public void displayStatus() {
        int occupied = activeTickets.size();
        int available = capacity - occupied;

        System.out.println("\n=== " + name.toUpperCase() + " STATUS REPORT ===");
        System.out.println("Total Capacity : " + capacity);
        System.out.println("Occupied Spots : " + occupied);
        System.out.println("Available Spots: " + available);
        System.out.println("=========================================\n");
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getCapacity() {
        return capacity;
    }
}