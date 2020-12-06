package service;

import model.Footballer;
import model.LongJumper;
import model.WeightLifter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class LongJumperService {
    public static void create() throws IOException {
        LongJumper ftbYet = new LongJumper();
        Scanner sc = new Scanner(System.in);
        while (ftbYet.getFirstName() == null) {
            System.out.print("First Name: ");
            String fName = sc.nextLine();
            try {
                ftbYet.setFirstName(fName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getLastName() == null) {
            System.out.print("Last Name: ");
            String lName = sc.nextLine();
            try {
                ftbYet.setLastName(lName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getHeight() == 0) {
            System.out.print("Height: ");
            String hh = sc.nextLine();
            try {
                double height = Double.parseDouble(hh);
                ftbYet.setHeight(height);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getWeight() == 0) {
            System.out.print("Weight: ");
            String hh = sc.nextLine();
            try {
                double weight = Double.parseDouble(hh);
                ftbYet.setWeight(weight);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getPace() == 0) {
            System.out.print("Pace: ");
            String hh = sc.nextLine();
            try {
                int pace = Integer.parseInt(hh);
                ftbYet.setPace(pace);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getPhysical() == 0) {
            System.out.print("Physical: ");
            String hh = sc.nextLine();
            try {
                int smth = Integer.parseInt(hh);
                ftbYet.setPhysical(smth);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getJumpingHeight() == 0) {
            System.out.print("Jumping Distance: ");
            String hh = sc.nextLine();
            try {
                int smth = Integer.parseInt(hh);
                ftbYet.setJumpingHeight(smth);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        String st = ftbYet.getFirstName() + "," + ftbYet.getLastName() + "," + ftbYet.getHeight() + ","
                + ftbYet.getWeight() + "," + ftbYet.getPace() + "," + ftbYet.getPhysical() + ","
                + ftbYet.getJumpingHeight();
        String stt = st + ",weightlifter\n";
        st = st + "\n";

        Files.write(Paths.get("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Sport_School_FinalProject\\src\\database\\longJumpers.txt"), st.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Sport_School_FinalProject\\src\\database\\sportsmen.txt"), stt.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Sport_School_FinalProject\\src\\database\\athletes.txt"), stt.getBytes(), StandardOpenOption.APPEND);

    }

    public static void printLongJumperByName() throws IOException {
        LongJumper ftbYet = new LongJumper();
        Scanner sc = new Scanner(System.in);
        while (ftbYet.getFirstName() == null) {
            System.out.print("First Name: ");
            String fName = sc.nextLine();
            try {
                ftbYet.setFirstName(fName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getLastName() == null) {
            System.out.print("Last Name: ");
            String lName = sc.nextLine();
            try {
                ftbYet.setLastName(lName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getHeight() == 0) {
            System.out.print("Height: ");
            String hh = sc.nextLine();
            try {
                double height = Double.parseDouble(hh);
                ftbYet.setHeight(height);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getWeight() == 0) {
            System.out.print("Weight: ");
            String hh = sc.nextLine();
            try {
                double weight = Double.parseDouble(hh);
                ftbYet.setWeight(weight);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        String[] array = {ftbYet.getFirstName(), ftbYet.getLastName(), ftbYet.getHeight() + "", ftbYet.getWeight() + ""};

        String[] infos = FileService.read("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Sport_School_FinalProject\\src\\database\\longJumpers.txt");
        String[] correctLine = null;
        for (String line : infos) {
            int k = 0;
            String[] lineSegmentated = line.split(",");
            for (int i = 0; i < array.length; i++) {
                if (!(lineSegmentated[i].equals(array[i]))) {
                    k = 0;
                    correctLine = null;
                    continue;
                }
                k = 1;
                correctLine = lineSegmentated;
            }
            if (k == 1) {
                break;
            }
        }
        if (correctLine == null) {
            System.out.println("No such person in our Long Jumpers' School. Would you like us to search in the " +
                    "whole Sports School?");
            while (true) {
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Input: ");
                String hh = sc.nextLine();
                int input = 0;
                try {
                    input = Integer.parseInt(hh);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                if (input == 1) {
                    SportsmenService.printFootballerByName(array);
                    return;
                }
                if (input == 2) {
                    return;
                }
            }
        }
        System.out.println(Arrays.toString(correctLine));
    }
}
