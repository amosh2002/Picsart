package main;

import Utils.ConsoleColors;
import model.InvalidCredentialsException;
import model.Sportsman;
import service.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidCredentialsException, IOException, NoSuchAlgorithmException {
        while (true) {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println(ConsoleColors.BLUE + "Hello! Welcome to our Sports School, choose an option to continue...");
            System.out.println(ConsoleColors.RESET + "1. Register a new Member");
            System.out.println("2. Login");
            System.out.println(ConsoleColors.RED_BRIGHT + "0. Quit");

            System.out.print(ConsoleColors.GREEN + "Input: ");
            int input;
            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED + "Input should be an integer, enter once again, please");
                continue;
            }
            switch (input) {
                case 1:
                    register();
                    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Registration Successful!");
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    System.exit(1);
            }

        }
    }

    private static void login() throws IOException, NoSuchAlgorithmException, InvalidCredentialsException {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleColors.RESET + "Username: ");
        String username = scanner.nextLine();
        System.out.print(ConsoleColors.RESET + "Password: ");
        String password = scanner.nextLine();
        System.out.println();

        String[] infos = FileService.read("Sport_School_FinalProject/src/database/user_base.txt");
        String matchedCode = "";
        Permissions matchedRole = null;
        for (String line : infos) {
            if (line.equals("")) {
                continue;
            }
            String[] usrLine = line.split(",");
            String code = MD5Service.getString(usrLine[1] + usrLine[usrLine.length - 2]);
            if (code.equals(MD5Service.getString(username + MD5Service.getString(password)))) {
                matchedCode = code;
                matchedRole = Permissions.valueOf(usrLine[usrLine.length - 1]);
            }
        }
        if (!matchedCode.equals("")) {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Login Successful!");

            System.out.println("Welcome ");
            if (matchedRole == Permissions.ADMIN) {
                adminFeatures();
            }
            if (matchedRole == Permissions.SPORTSMAN) {
                sportsmenFeatures(matchedCode);
            }
            return;
        }
        System.out.println(ConsoleColors.RED_BRIGHT + "No such user found");
    }


    public static void register() throws IOException, InvalidCredentialsException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Choose the School and your profile...");
        System.out.println(ConsoleColors.RESET + "1. Register as a new Footballer to our Football School");
        System.out.println("2. Register as a new Long Jumper to our Athletes - Long Jumpers' School");
        System.out.println("3. Register as a new Sprinter to our Athletes - Sprinters' School");
        System.out.println("4. Register as a new Weight Lifter to our Athletes - Weight Lifters' School");
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "5. Go Back");

        System.out.println(ConsoleColors.RED_BRIGHT + "0. Quit");
        System.out.print(ConsoleColors.GREEN + "Input: ");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Input should be an integer, enter once again, please");
            register();
        }
        switch (input) {
            case 1:
                FootballerService.create();
                break;
            case 2:
                LongJumperService.create();
                break;
            case 3:
                SprinterService.create();
                break;
            case 4:
                WeightLifterService.create();
                break;
            case 5:
                main(new String[1]);
            case 0:
                System.exit(0);
        }
    }

    public static void adminFeatures() throws IOException, InvalidCredentialsException, NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.RESET + "1. See information of a Member");
        System.out.println("2. See all Members");
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "3. Go Back");
        System.out.println(ConsoleColors.RED_BRIGHT + "0. Quit");
        System.out.print(ConsoleColors.GREEN + "Input: ");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Input should be an integer, enter once again, please");
            adminFeatures();
        }
        switch (input) {
            case 1:
                findToPrint();
                break;
            case 2:
                SportsmenService.printAllMembers();
                break;
            case 3:
                main(new String[1]);
            case 0:
                System.exit(2);
        }
        adminFeatures();

    }

    private static void sportsmenFeatures(String code) throws IOException, NoSuchAlgorithmException, InvalidCredentialsException {
        Sportsman sp;

        try {
            sp = SportsmenService.getMemberByID(code);
        } catch (Exception e) {
            System.out.println("Could not find such member, please try again");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. See your information");
        System.out.println("2. See your team Members");
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "3. Go Back");
        System.out.println(ConsoleColors.RED_BRIGHT + "0. Quit");
        System.out.print(ConsoleColors.GREEN + "Input: ");
        System.out.print(ConsoleColors.PURPLE_BOLD);
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Input should be an integer, enter once again, please");
            sportsmenFeatures(code);
        }
        switch (input) {
            case 1:
                if (sp != null) {
                    SportsmenService.printInfo(sp);
                }
                break;
            case 2:
                if (sp != null) {
                    SportsmenService.printAllTeamMembers(sp.getClass().getSimpleName());
                }
                break;
            case 3:
                main(new String[1]);
            case 0:
                System.exit(2);
        }
        sportsmenFeatures(code);
    }

    public static void findToPrint() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Which School is that student from?");
        System.out.println(ConsoleColors.RESET + "1. Football School");
        System.out.println("2. Athletes - Long Jumpers' School");
        System.out.println("3. Athletes - Sprinters' School");
        System.out.println("4. Athletes - Weight Lifters' School");

        System.out.println(ConsoleColors.YELLOW_BRIGHT + "5. Go Back");
        System.out.println(ConsoleColors.RED_BRIGHT + "0. Quit");
        System.out.print(ConsoleColors.GREEN + "Input: ");
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Input should be an integer, enter once again, please");
            findToPrint();
        }
        switch (input) {
            case 1:
                FootballerService.printFootballerByName();
                System.out.print(ConsoleColors.RESET);
                break;
            case 2:
                LongJumperService.printLongJumperByName();
                System.out.print(ConsoleColors.RESET);
                break;
            case 3:
                SprinterService.printSprinterByName();
                System.out.print(ConsoleColors.RESET);
                break;
            case 4:
                WeightLifterService.printWeightLiferByName();
                System.out.print(ConsoleColors.RESET);
                break;
            case 5:
                return;
            case 0:
                System.exit(0);
        }
    }
}
