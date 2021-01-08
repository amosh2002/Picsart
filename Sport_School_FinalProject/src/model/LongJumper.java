package model;

public class LongJumper extends Athlete {
    public int jumpingHeight;

    @Override
    public void print() {
        super.print();
        System.out.println("Physical: " + physical);
        System.out.println("Jumping Distance: " + jumpingHeight);
    }

    public LongJumper() {
        super();
    }

    public LongJumper(int pace, int physical, int jumpingHeight) {
        super(pace, physical);
        try {
            setJumpingHeight(jumpingHeight);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
    }

    public LongJumper(String firstName, String lastName, double height, double weight, String username, String email, String password, int pace, int physical, int jumpingHeight) {
        super(firstName, lastName, height, weight, username, email, password, pace, physical);
        try {
            setJumpingHeight(jumpingHeight);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }    }

    public int getJumpingHeight() {
        return jumpingHeight;
    }

    public void setJumpingHeight(int jumpingHeight) throws InvalidCredentialsException {
        if (jumpingHeight < 1 || jumpingHeight > 10) {
            throw new InvalidCredentialsException("Jumping Height should be above 1 and below 10, Your input: '" + jumpingHeight + "'");
        }
        this.jumpingHeight = jumpingHeight;
    }


}
