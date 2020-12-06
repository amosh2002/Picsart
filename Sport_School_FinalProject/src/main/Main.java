package main;

import model.InvalidCredentialsException;
import service.FootballerService;
import service.LongJumperService;
import service.SprinterService;
import service.WeightLifterService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidCredentialsException, IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello! Welcome to our Sports School, choose an option to continue...");
            System.out.println("1. Register a new Member");
            System.out.println("2. See the Information of a Sportsman");
            System.out.println("0. Quit");

            System.out.print("Input: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    register();
                    System.out.println("Registration Successful!");
                    break;
                case 2:
                    findToPrint();
                    break;
                case 0:
                    System.exit(1);
            }

        }
    }

    public static void register() throws IOException, InvalidCredentialsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Register as a new Footballer to our Football School");
        System.out.println("2. Register as a new Long Jumper to our Athletes - Long Jumpers' School");
        System.out.println("3. Register as a new Sprinter to our Athletes - Sprinters' School");
        System.out.println("4. Register as a new Weight Lifter to our Athletes - Weight Lifters' School");
        System.out.println("5. Go Back");

        System.out.println("0. Quit");
        System.out.print("Input: ");
        int input = scanner.nextInt();
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
                return;
            case 0:
                System.exit(0);
        }
    }

    public static void findToPrint() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which School are you from?");
        System.out.println("1. Football School");
        System.out.println("2. Athletes - Long Jumpers' School");
        System.out.println("3. Athletes - Sprinters' School");
        System.out.println("4. Athletes - Weight Lifters' School");

        System.out.println("5. Go Back");
        System.out.println("0. Quit");
        System.out.print("Input: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                FootballerService.printFootballerByName();
                break;
            case 2:
                LongJumperService.printLongJumperByName();
                break;
            case 3:
                SprinterService.printSprinterByName();
                break;
            case 4:
                WeightLifterService.printWeightLiferByName();
                break;
            case 5:
                return;
            case 0:
                System.exit(0);
        }
    }
}
