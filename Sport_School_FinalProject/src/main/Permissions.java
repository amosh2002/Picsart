package main;

public enum Permissions {
    ADMIN("ADMIN"), SPORTSMAN("SPORTSMAN");
    private final String role;

    private Permissions(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
