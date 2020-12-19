package model;

public class Footballer extends Sportsman implements SpeedRunner {
    protected char preferredFoot;
    protected String position;
    protected int pace;
    protected int shooting;
    protected int passing;
    protected int dribbling;
    protected int defending;
    protected int physical;
    protected int heading;


    public Footballer() {
        super();
    }


    public char getPreferredFoot() {
        return preferredFoot;
    }

    public void setPreferredFoot(char preferredFoot) throws InvalidCredentialsException {
        if (preferredFoot != 'l' && preferredFoot != 'r') {
            throw new InvalidCredentialsException("Preferred Foot should be either 'l' or 'r', Your input: '" + preferredFoot + "'");
        }
        this.preferredFoot = preferredFoot;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) throws InvalidCredentialsException {
        if (position.length() == 0) {
            throw new InvalidCredentialsException("Position String should be longer than 1 character, Your input: '" + preferredFoot + "'");
        }
        this.position = position;
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

    public int getShooting() {
        return shooting;
    }

    public void setShooting(int shooting) throws InvalidCredentialsException {
        if (shooting < 1 || shooting > 10) {
            throw new InvalidCredentialsException("Shooting should be above 1 and below 10, Your input: '" + shooting + "'");
        }
        this.shooting = shooting;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) throws InvalidCredentialsException {
        if (passing < 1 || passing > 10) {
            throw new InvalidCredentialsException("Passing should be above 1 and below 10, Your input: '" + passing + "'");
        }
        this.passing = passing;
    }

    public int getDribbling() {
        return dribbling;
    }

    public void setDribbling(int dribbling) throws InvalidCredentialsException {
        if (dribbling < 1 || dribbling > 10) {
            throw new InvalidCredentialsException("Dribbling should be above 1 and below 10, Your input: '" + dribbling + "'");
        }
        this.dribbling = dribbling;
    }

    public int getDefending() {
        return defending;
    }

    public void setDefending(int defending) throws InvalidCredentialsException {
        if (defending < 1 || defending > 10) {
            throw new InvalidCredentialsException("Defending should be above 1 and below 10, Your input: '" + defending + "'");
        }
        this.defending = defending;
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

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) throws InvalidCredentialsException {
        if (heading < 1 || heading > 10) {
            throw new InvalidCredentialsException("Heading should be above 1 and below 10, Your input: '" + heading + "'");
        }
        this.heading = heading;
    }

    @Override
    public void boostSpeed(int speedToBoost) {
        this.pace += speedToBoost;
        this.physical += speedToBoost / 2;
    }
}
