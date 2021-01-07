package model;

public class Sprinter extends Athlete implements SpeedRunner {

    public Sprinter(){
        super();
    }

    public Sprinter(int pace, int physical) {
        super(pace, physical);
    }

    public Sprinter(String firstName, String lastName, double height, double weight, String username, String email, String password, int pace, int physical) {
        super(firstName, lastName, height, weight, username, email, password, pace, physical);
    }

    @Override
    public void boostSpeed(int speedToAdd) {
        this.pace += speedToAdd * 1.5;
        this.physical += speedToAdd / 2;
    }
}
