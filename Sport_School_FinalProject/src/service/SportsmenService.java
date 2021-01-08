package service;

import Utils.ConsoleColors;
import model.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SportsmenService {
    public static void printSportsmanByName(String[] array) throws IOException {
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/sportsmen.txt");
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
            System.out.println("No such person found");
            return;
        }

        System.out.println(ConsoleColors.PURPLE_BOLD + (Arrays.toString(correctLine)).substring(1, Arrays.toString(correctLine).length() - 1));
    }

    public static void printAllMembers() throws IOException {
        System.out.println(ConsoleColors.BLUE + "Printing the full list of all members...");
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/sportsmen.txt");
        for (String line : infos) {
            System.out.println(ConsoleColors.PURPLE_BOLD + (Arrays.toString(line.split(","))).substring(1, Arrays.toString(line.split(",")).length() - 1));
        }
    }

    public static void printAllTeamMembers(String className) throws IOException {
        System.out.println(ConsoleColors.BLUE + "Printing the full list of all team members...");
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/" + className.substring(0, 1).toLowerCase() + className.substring(1) + "s.txt");
        int i = 1;
        for (String line : infos) {
            System.out.println(ConsoleColors.PURPLE_BOLD + i++ + ". " + (line.split(","))[0]);
        }
    }

    public static Sportsman getMemberByID(String id) throws IOException, NoSuchAlgorithmException {
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/sportsmen.txt");
        String[] userInfos = FileService.read("Sport_School_FinalProject/src/database/user_base.txt");
        String[] correctSegmentated = null;
        String[] userCorrectSegmentated = null;
        for (String line : infos) {
            String[] lineSegmentated = line.split(",");
            String idFromDoc = lineSegmentated[lineSegmentated.length - 1];
            if (id.equals(idFromDoc)) {
                correctSegmentated = lineSegmentated;
            }
        }
        for (String line : userInfos) {
            String[] lineSegmentated = line.split(",");
            String passwordHashed = lineSegmentated[lineSegmentated.length - 2];
            String completeKey = MD5Service.getString(lineSegmentated[1] + passwordHashed);
            if (id.equals(completeKey)) {
                userCorrectSegmentated = lineSegmentated;
            }
        }

        if (correctSegmentated == null || userCorrectSegmentated == null) {
            return null;
        }
        System.out.print(ConsoleColors.RESET);
        switch (correctSegmentated[correctSegmentated.length - 2]) {
            case "footballer":
                try {
                    return new Footballer(correctSegmentated[0].split(" ")[0], correctSegmentated[0].split(" ")[1],
                            Double.parseDouble(correctSegmentated[1]), Double.parseDouble(correctSegmentated[2]),
                            userCorrectSegmentated[1], userCorrectSegmentated[2], userCorrectSegmentated[3],
                            correctSegmentated[3].charAt(0), correctSegmentated[4], Integer.parseInt(correctSegmentated[5]),
                            Integer.parseInt(correctSegmentated[6]), Integer.parseInt(correctSegmentated[7]), Integer.parseInt(correctSegmentated[8]),
                            Integer.parseInt(correctSegmentated[9]), Integer.parseInt(correctSegmentated[10]), Integer.parseInt(correctSegmentated[11]));
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "longJumper":
                try {
                    return new LongJumper(correctSegmentated[0].split(" ")[0], correctSegmentated[0].split(" ")[1],
                            Double.parseDouble(correctSegmentated[1]), Double.parseDouble(correctSegmentated[2]), userCorrectSegmentated[1],
                            userCorrectSegmentated[2], userCorrectSegmentated[3], Integer.parseInt(correctSegmentated[3]), Integer.parseInt(correctSegmentated[4]),
                            Integer.parseInt(correctSegmentated[5]));
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "weightLifter":
                try {
                    return new WeightLifter(correctSegmentated[0].split(" ")[0],correctSegmentated[0].split(" ")[1],
                            Double.parseDouble(correctSegmentated[1]),Double.parseDouble(correctSegmentated[1]),
                            userCorrectSegmentated[1],userCorrectSegmentated[2],userCorrectSegmentated[3],
                            0,Integer.parseInt(correctSegmentated[3]),Integer.parseInt(correctSegmentated[4]));
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "sprinter":
                try {
                    return new Sprinter(correctSegmentated[0].split(" ")[0],correctSegmentated[0].split(" ")[1],
                            Double.parseDouble(correctSegmentated[1]),Double.parseDouble(correctSegmentated[2]),
                            userCorrectSegmentated[1],userCorrectSegmentated[2],userCorrectSegmentated[3],Integer.parseInt(correctSegmentated[3]),
                            Integer.parseInt(correctSegmentated[4]));
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
        }
        return null;
    }

    public static void printInfo(Sportsman sp) {
        System.out.println(sp.getFirstName() + " " + sp.getLastName() + ", " + sp.getEmail() + ", " + sp.getUsername());
    }
}

