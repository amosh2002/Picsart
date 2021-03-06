package model;

import service.FileService;
import service.MD5Service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Sportsman implements Printable {
    protected String firstName;
    protected String lastName;
    protected double height;
    protected double weight;

    private String username;
    private String email;
    private String password;

    @Override
    public void print() {
        System.out.println("Full name: " + firstName + " " + lastName);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }

    public Sportsman() {

    }

    public Sportsman(String firstName, String lastName, double height, double weight, String username, String email, String password) {

        try {
            setFirstName(firstName);
            setLastName(lastName);
            setHeight(height);
            setWeight(weight);
            setUsername(username);
            setEmail(email);
            setPassword(password);
        } catch (InvalidCredentialsException | IOException | NoSuchAlgorithmException e) {
            System.out.println(e.toString());
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidCredentialsException, IOException {
        if (username.length() <= 10) {
            throw new InvalidCredentialsException("Username should be longer than 10 characters, Your input: '" + username + "'");
        }
        this.username = username;
    }

    public void setNonCheckedUsername(String username) throws IOException, InvalidCredentialsException {
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/user_base.txt");
        for (String line : infos) {
            if (line.equals("")) {
                continue;
            }
            String usr = line.split(",")[1];
            if (username.equals(usr)) {
                throw new InvalidCredentialsException("This username is already taken");
            }
        }
        setUsername(username);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidCredentialsException {
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidCredentialsException("email should be of form 'mymail@example.com', Your input: '" + email + "'");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidCredentialsException, NoSuchAlgorithmException {
        this.password = password;
    }

    public void setPasswordNotHashed(String password) throws InvalidCredentialsException, NoSuchAlgorithmException {
        String regex = "^(?=.{8,}$)(?=(?:.*?[A-Z]){2})(?=(?:.*?[0-9]){3}).*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidCredentialsException("password should contain more than 8 characters, contain 2 uppercase letters and 3 numbers, Your input: '" + password + "'");
        }
        this.password = MD5Service.getString(password);
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
