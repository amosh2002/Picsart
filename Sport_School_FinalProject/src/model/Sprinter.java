package model;

public class Sprinter extends Athlete {

    @Override
    public void print() {
        super.print();
        System.out.println("Pace: " + pace);
        System.out.println("Physical: " + physical);
    }

    public Sprinter() {
        super();
    }

    public Sprinter(int pace, int physical) {
        super(pace, physical);
    }

    public Sprinter(String firstName, String lastName, double height, double weight, String username, String email, String password, int pace, int physical) {
        super(firstName, lastName, height, weight, username, email, password, pace, physical);
    }
}
