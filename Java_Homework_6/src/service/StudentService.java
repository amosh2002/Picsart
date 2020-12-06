package service;


import model.Student;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {
    public static Student[] create(String path) throws IOException {
        String[] read = FileService.read(path);
        Student[] students = new Student[read.length];
        int i = 0;
        for (String potentialStudent : read) {
            String[] studentData = potentialStudent.split(",");
            students[i++] = new Student(studentData[0], studentData[1], Integer.parseInt(studentData[2]),
                    studentData[3].charAt(0), Double.parseDouble(studentData[4]));
        }
        return students;
    }

    public static void printFullNames(Student[] students) {
        for (Student st : students) {
            System.out.println(st.getfName() + " " + st.getlName());
        }
    }

    public static void printAllMales(Student[] students) {
        for (Student st : students) {
            if (st.getGender() != 'm') {
                continue;
            }
            System.out.println(st.toString());
        }
    }

    public static void printAllFemalesGreaterThan50_4(Student[] students) {
        for (Student st : students) {
            if (st.getGender() != 'f' || st.getGrade() <= 50.4) {
                continue;
            }
            System.out.println(st.toString());
        }
    }

    public static void printBiggestMaleStudentInformation(Student[] students) {
        Student biggest = null;
        for (Student st : students) {
            if (biggest == null) {
                if (st.getGender() == 'm') {
                    biggest = st;
                }
                continue;
            }
            if (st.getGender() == 'm' && st.getYear() < biggest.getYear()) {
                biggest = st;
            }
        }
        System.out.println(biggest);
    }

    public static void printStudentsSortedByMarkAscending(Student[] students) {
        Student[] newStudents = students.clone();
        Arrays.sort(newStudents);
        System.out.println(Arrays.toString(newStudents));
    }

    public static void printFemaleStudentsByYear(Student[] students) {
        Student[] females;
        int length = 0;
        for (Student st : students) {
            if (st.getGender() == 'f') {
                length++;
            }
        }
        females = new Student[length];
        length = 0;
        for (Student st : students) {
            if (st.getGender() == 'f') {
                females[length++] = st;
            }
        }
        Arrays.sort(females, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getYear() - o2.getYear();
            }
        });
        System.out.println(Arrays.toString(females));

    }
}

