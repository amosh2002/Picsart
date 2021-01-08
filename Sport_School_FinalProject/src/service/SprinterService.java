package service;

import Utils.ConsoleColors;
import main.Permissions;
import model.Sprinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class SprinterService {
    public static void create() throws IOException, NoSuchAlgorithmException {
        Sprinter ftbYet = new Sprinter();
        Scanner sc = new Scanner(System.in);
        while (ftbYet.getUsername() == null) {
            System.out.print("Username: ");
            String fName = sc.nextLine();
            try {
                ftbYet.setUsername(fName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getEmail() == null) {
            System.out.print("E-mail: ");
            String fName = sc.nextLine();
            try {
                ftbYet.setEmail(fName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        while (ftbYet.getPassword() == null) {
            System.out.print("Password: ");
            String fName = sc.nextLine();
            try {
                ftbYet.setPasswordNotHashed(fName);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
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
        String loginData = ftbYet.getFirstName() + " " + ftbYet.getLastName() + "," + ftbYet.getUsername() + ","
                + ftbYet.getEmail() + "," + ftbYet.getPassword() + "," + Permissions.SPORTSMAN + "\n";
        String st = ftbYet.getFirstName() + " " + ftbYet.getLastName() + "," + ftbYet.getHeight() + ","
                + ftbYet.getWeight() + "," + ftbYet.getPace() + "," + ftbYet.getPhysical();
        String stt = st + ",sprinter," + MD5Service.getString(ftbYet.getUsername() + ftbYet.getPassword()) + "\n";
        st = st + "," + MD5Service.getString(ftbYet.getUsername() + ftbYet.getPassword()) + "\n";


        Files.write(Paths.get("Sport_School_FinalProject/src/database/sprinters.txt"), st.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("Sport_School_FinalProject/src/database/sportsmen.txt"), stt.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("Sport_School_FinalProject/src/database/athletes.txt"), stt.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get("Sport_School_FinalProject/src/database/user_base.txt"), loginData.getBytes(), StandardOpenOption.APPEND);


    }

    public static void printSprinterByName() throws IOException {
        Sprinter ftbYet = new Sprinter();
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

        String[] array = {ftbYet.getFirstName() + " " + ftbYet.getLastName(), ftbYet.getHeight() + "", ftbYet.getWeight() + ""};

        String[] infos = FileService.read("Sport_School_FinalProject/src/database/sprinters.txt");
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
            System.out.println(ConsoleColors.RED + "No such person in our Sprinters' School. Would you like us to search in the " +
                    "whole Sports School?");
            while (true) {
                System.out.println(ConsoleColors.RESET + "1. Yes");
                System.out.println("2. No");
                System.out.print(ConsoleColors.GREEN + "Input: ");
                String hh = sc.nextLine();
                int input = 0;
                try {
                    input = Integer.parseInt(hh);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                if (input == 1) {
                    SportsmenService.printSportsmanByName(array);
                    return;
                }
                if (input == 2) {
                    return;
                }
            }
        }
        System.out.println(ConsoleColors.PURPLE_BOLD + (Arrays.toString(correctLine)).substring(1, Arrays.toString(correctLine).length() - 1));
    }
}
