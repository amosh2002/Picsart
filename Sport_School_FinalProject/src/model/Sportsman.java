package model;

public abstract class Sportsman {
    protected String firstName;
    protected String lastName;
    protected double height;
    protected double weight;

    public Sportsman(String firstName, String lastName, double height, double weight) {
        try {
            setFirstName(firstName);
            setLastName(lastName);
            setHeight(height);
            setWeight(weight);
        } catch (InvalidCredentialsException e) {
            System.out.println(e);
        }
    }

    public Sportsman(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidCredentialsException {
        if (firstName.length() == 0) {
            throw new InvalidCredentialsException("First Name should contain at least 1 character, Your input: '" + firstName + "'");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidCredentialsException {
        if (lastName.length() == 0) {
            throw new InvalidCredentialsException("Last Name should contain at least 1 character, Your input: '" + lastName + "'");
        }
        this.lastName = lastName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws InvalidCredentialsException {
        if (height < 60 || height > 220) {
            throw new InvalidCredentialsException("Height should be above 60cm and below 220cm, Your input: '" + height + "'");
        }
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidCredentialsException {
        if (weight < 10 || weight > 120) {
            throw new InvalidCredentialsException("Weight should be more than 10kg and less than 120kg, Your input: '" + weight + "'");
        }
        this.weight = weight;
    }



}
