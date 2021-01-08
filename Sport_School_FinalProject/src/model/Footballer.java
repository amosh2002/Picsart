package model;

public class Footballer extends Sportsman {
    protected char preferredFoot;
    protected String position;
    protected int pace;
    protected int shooting;
    protected int passing;
    protected int dribbling;
    protected int defending;
    protected int physical;
    protected int heading;

    @Override
    public void print() {
        super.print();
        System.out.println("Preferred foot: " + (preferredFoot == 'l' ? "Left" : "Right"));
        System.out.println("Position: " + position);
        System.out.println("Pace: " + pace);
        System.out.println("Shooting: " + shooting);
        System.out.println("Passing: " + passing);
        System.out.println("Dribbling: " + dribbling);
        System.out.println("Defending: " + defending);
        System.out.println("Physical: " + physical);
        System.out.println("Heading: " + heading);
    }


    public Footballer() {
        super();
    }

    public Footballer(char preferredFoot, String position, int pace, int shooting, int passing, int dribbling, int defending, int physical, int heading) {
        try {
            setPreferredFoot(preferredFoot);
            setPosition(position);
            setPace(pace);
            setShooting(shooting);
            setPassing(passing);
            setDribbling(dribbling);
            setDefending(defending);
            setPhysical(physical);
            setHeading(heading);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
    }

    public Footballer(String firstName, String lastName, double height, double weight, String username, String email, String password, char preferredFoot, String position, int pace, int shooting, int passing, int dribbling, int defending, int physical, int heading) {
        super(firstName, lastName, height, weight, username, email, password);
        try {
            setPreferredFoot(preferredFoot);
            setPosition(position);
            setPace(pace);
            setShooting(shooting);
            setPassing(passing);
            setDribbling(dribbling);
            setDefending(defending);
            setPhysical(physical);
            setHeading(heading);
        } catch (InvalidCredentialsException e) {
            System.out.println(e.toString());
        }
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
}
