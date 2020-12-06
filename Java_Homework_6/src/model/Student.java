package model;

public class Student implements Comparable<Student> {
    private String fName, lName;
    private int year;
    private char gender;
    private double grade;

    public Student(String fName, String lName, int year, char gender, double grade) {
        setfName(fName);
        setlName(lName);
        setYear(year);
        setGender(gender);
        setGrade(grade);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return fName + "," + lName + "," + year + "," + gender + "," + grade;
    }

    @Override
    public int compareTo(Student o) {
        return (int) ((int) grade - o.getGrade());
    }
}
