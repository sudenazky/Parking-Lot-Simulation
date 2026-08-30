package SmartParkinglot;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE SMART PARKING LOT SYSTEM TEST INITIATED ===\n");

        Payment cash = new CashPayment();
        Payment card = new CardPayment();

        CompactParkingArea compactSpot = new CompactParkingArea("Compact Area", 20.0, 2);
        LargeVehicleZone largeSpot = new LargeVehicleZone("Large Vehicle Area", 50.0, 10);
        MotorcycleLot motoSpot = new MotorcycleLot("Motorcycle Area", 10.0, 10);
        CompactParkingArea freeSpot = new CompactParkingArea("Free (Invalid) Area", 0.0, 5);

        System.out.println("--- SCENARIO 1: INVALID OBJECT CREATION TESTS ---");

        try {
            System.out.println("Test 1.1: Attempting to create a user with an empty name...");
            User invalidUser = new User("");
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESSFULLY CAUGHT EXCEPTION: " + e.getMessage());
        }

        try {
            System.out.println("Test 1.2: Attempting to create a motorcycle with negative engine capacity...");
            User testUser = new User("Test User");
            Motorcycle invalidMoto = new Motorcycle("Test Moto", "11 AA 11", testUser, -50);
        } catch (IllegalArgumentException e) {
            System.out.println("SUCCESSFULLY CAUGHT EXCEPTION: " + e.getMessage());
        }
        System.out.println();


        System.out.println("--- SCENARIO 2: CREATING VEHICLES AND DISPLAYING INFO ---");

        User u1 = new User("John Doe");
        User u2 = new User("Jane Smith");
        User u3 = new User("Michael Johnson");

        Car car1 = new Car("Honda Civic", "34 ABC 01", u1, false);
        Car car2 = new Car("Tesla Model 3", "34 ABC 02", u2, true);
        Car car3 = new Car("Ford Focus", "34 ABC 03", u3);

        Truck truck1 = new Truck("Scania R500", "06 KMN 55", 20000, u1);
        Motorcycle moto1 = new Motorcycle("Yamaha MT-07", "35 XYZ 99", u2, 700);

        System.out.println("[CAR 1 INFO]");
        car1.showInfo();
        System.out.println();

        System.out.println("[CAR 2 INFO]");
        car2.showInfo();
        System.out.println();

        System.out.println("[TRUCK 1 INFO]");
        truck1.showInfo();
        System.out.println();

        System.out.println("[MOTORCYCLE 1 INFO]");
        moto1.showInfo();
        System.out.println();


        System.out.println("--- SCENARIO 3: WRONG PARKING SPOT TESTS ---");
        System.out.println("Test 3.1: Attempting to park a TRUCK in a COMPACT spot...");
        compactSpot.parkVehicle(truck1);

        System.out.println("\nTest 3.2: Attempting to park a MOTORCYCLE in a LARGE spot...");
        largeSpot.parkVehicle(moto1);
        System.out.println();


        System.out.println("--- SCENARIO 4: CAPACITY LIMIT TEST (Max Capacity: 2) ---");
        System.out.println("1. Parking the first car...");
        ParkingTicket ticket1 = compactSpot.parkVehicle(car1);

        System.out.println("\n2. Parking the second car...");
        ParkingTicket ticket2 = compactSpot.parkVehicle(car2);

        System.out.println("\n3. Attempting to park the third car...");
        ParkingTicket ticket3 = compactSpot.parkVehicle(car3);
        System.out.println();


        System.out.println("--- SCENARIO 5: PARKING LOT STATUS REPORT ---");
        compactSpot.displayStatus();


        System.out.println("--- SCENARIO 6: CHECKOUT AND PAYMENT TESTS ---");

        System.out.println("Test 6.1: Attempting to exit with a non-existent/invalid ticket number...");
        compactSpot.processExit("TICK-INVALID123", cash);
        System.out.println();

        System.out.println("Test 6.2: Attempting an invalid (0$) payment...");
        ParkingTicket freeTicket = freeSpot.parkVehicle(car3);
        System.out.println("Initiating checkout process...");
        freeSpot.processExit(freeTicket.getTicketNumber(), card);
        System.out.println();

        System.out.println("Test 6.3: Valid Cash Payment and Checkout...");
        compactSpot.processExit(ticket1.getTicketNumber(), cash);
        System.out.println();

        System.out.println("Test 6.4: Valid Card Payment and Checkout...");
        compactSpot.processExit(ticket2.getTicketNumber(), card);
        System.out.println();


        System.out.println("--- SCENARIO 7: FINAL STATUS REPORT AFTER CHECKOUTS ---");
        compactSpot.displayStatus();
    }
}