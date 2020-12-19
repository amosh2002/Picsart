package model;

public class Sprinter extends Athlete implements SpeedRunner {

    public Sprinter(){
        super();
    }

    @Override
    public void boostSpeed(int speedToAdd) {
        this.pace += speedToAdd * 1.5;
        this.physical += speedToAdd / 2;
    }
}
