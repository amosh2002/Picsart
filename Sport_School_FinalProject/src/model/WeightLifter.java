package model;

public class WeightLifter extends Athlete {
    protected int strength;


    @Override
    public void print() {
        super.print();
        System.out.println("Physical: " + physical);
        System.out.println("Strength: " + strength);
    }

    public WeightLifter() {
        super();
    }

    public WeightLifter(int pace, int physical, int strength) {
        super(pace, physical);
        try {
            setStrength(strength);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
    }

    public WeightLifter(String firstName, String lastName, double height, double weight, String username, String email, String password, int pace, int physical, int strength) {
        super(firstName, lastName, height, weight, username, email, password, pace, physical);
        try {
            setStrength(strength);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) throws InvalidCredentialsException {
        if (strength < 1 || strength > 10) {
            throw new InvalidCredentialsException("Strength should be above 1 and below 10, Your input: '" + strength + "'");
        }
        this.strength = strength;
    }

}
