package Java_InClass;

public class Student {
    private String name;
    private int age;
    private char gender;

    public Student(String str) {
        String[] strArr = str.split(",");
        name=strArr[0];
        age=Integer.parseInt(strArr[1]);
        gender=strArr[2].charAt(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
