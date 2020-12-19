package model;

public class WeightLifter extends Athlete implements RockStrong {
    protected int strength;


    public WeightLifter() {
        super();
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

    @Override
    public void boostStrength(int strengthBoost) throws InvalidCredentialsException {
        if (strengthBoost < 1 || strengthBoost > 5) {
            throw new InvalidCredentialsException("Strength should be above 1 and below 5, Your input: '" + strengthBoost + "'");
        }
        strength += strengthBoost;
        physical += strengthBoost * 1.8;
        if (strength > 15) {
            strength = 15;
        }
        if (physical > 13) {
            physical = 13;
        }
    }
}
