package SmartParkinglot;

public enum VehicleType {
        CAR(1.0),
        MOTORCYCLE(0.5),
        TRUCK(2.0);

    private final double feeMultiplier;

        VehicleType(double feeMultiplier) {
            this.feeMultiplier=feeMultiplier;
        }
        public double getFeeMultiplier() {
            return feeMultiplier;
        }
    }

