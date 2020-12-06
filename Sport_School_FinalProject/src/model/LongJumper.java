package model;

public class LongJumper extends Athlete implements SpeedRunner, HighJumper {
    public int jumpingHeight;

    public LongJumper(String firstName, String lastName, double height, double weight, int pace, int physical, int jumpingHeight) {
        super(firstName, lastName, height, weight, pace, physical);
        try {
            setJumpingHeight(jumpingHeight);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
    }

    public LongJumper(){
        super();
    }


    public int getJumpingHeight() {
        return jumpingHeight;
    }

    public void setJumpingHeight(int jumpingHeight) throws InvalidCredentialsException {
        if (jumpingHeight < 1 || jumpingHeight > 10) {
            throw new InvalidCredentialsException("Jumping Height should be above 1 and below 10, Your input: '" + jumpingHeight + "'");
        }
        this.jumpingHeight = jumpingHeight;
    }

    @Override
    public void jumpHigher(int jumpingBoost) throws InvalidCredentialsException {
        if (jumpingBoost < 1 || jumpingBoost > 3) {
            throw new InvalidCredentialsException("Jumping Boost should be above 1 and below 3, Your input: '" + jumpingBoost + "'");
        }
        this.jumpingHeight += jumpingBoost * 1.3;
        if (jumpingHeight > 12) {
            jumpingHeight = 12;
        }
    }

    @Override
    public void boostSpeed(int speedToAdd) throws InvalidCredentialsException {
        if (speedToAdd < 1 || speedToAdd > 3) {
            throw new InvalidCredentialsException("Speed Boost should be above 1 and below 3, Your input: '" + speedToAdd + "'");
        }
        pace += speedToAdd;
        physical += speedToAdd / 3;

        if (pace > 12) {
            pace = 12;
        }
        if (physical > 12) {
            physical = 12;
        }


    }
}
