package main;

import model.Student;
import service.StudentService;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Student[] students = StudentService.create("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Java_Homework_6\\students.txt");
        System.out.println(Arrays.toString(students));
        StudentService.printFullNames(students);
        StudentService.printAllMales(students);
        StudentService.printAllFemalesGreaterThan50_4(students);
        StudentService.printBiggestMaleStudentInformation(students);
        StudentService.printStudentsSortedByMarkAscending(students);
        StudentService.printFemaleStudentsByYear(students);
    }
}
