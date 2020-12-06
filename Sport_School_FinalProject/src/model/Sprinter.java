package model;

public class Sprinter extends Athlete implements SpeedRunner {
    public Sprinter(String firstName, String lastName, double height, double weight, int pace, int physical) {
        super(firstName, lastName, height, weight, pace, physical);
    }

    public Sprinter(){
        super();
    }

    @Override
    public void boostSpeed(int speedToAdd) {
        this.pace += speedToAdd * 1.5;
        this.physical += speedToAdd / 2;
    }
}
