package model;

public abstract class Athlete extends Sportsman {
    protected int pace;
    protected int physical;

    public Athlete() {

    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) throws InvalidCredentialsException {
        if (pace < 1 || pace > 10) {
            throw new InvalidCredentialsException("Pace should be above 1 and below 10, Your input: '" + pace + "'");
        }
        this.pace = pace;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) throws InvalidCredentialsException {
        if (physical < 1 || physical > 10) {
            throw new InvalidCredentialsException("Physical should be above 1 and below 10, Your input: '" + physical + "'");
        }
        this.physical = physical;
    }
}
