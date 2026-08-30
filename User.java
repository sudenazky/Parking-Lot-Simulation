package SmartParkinglot;

public class User {
    private final String name;

    public User(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}