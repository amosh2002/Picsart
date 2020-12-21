package service;

import Utils.ConsoleColors;
import model.*;

import java.io.IOException;
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

    public static Sportsman getMemberByID(String id) throws IOException {
        String[] infos = FileService.read("Sport_School_FinalProject/src/database/sportsmen.txt");
        String[] correctSegmentated = null;
        for (String line : infos) {
            String[] lineSegmentated = line.split(",");
            String idFromDoc = lineSegmentated[lineSegmentated.length - 1];
            if (id.equals(idFromDoc)) {
                correctSegmentated = lineSegmentated;
            }
        }

        if (correctSegmentated == null) {
            return null;
        }
        switch (correctSegmentated[correctSegmentated.length - 2]) {
            case "footballer":
                Footballer toBeReturned = new Footballer();
                try {
                    toBeReturned.setFirstName(correctSegmentated[0].split(" ")[0]);
                    toBeReturned.setLastName(correctSegmentated[0].split(" ")[1]);
                    toBeReturned.setHeight(Double.parseDouble(correctSegmentated[1]));
                    toBeReturned.setWeight(Double.parseDouble(correctSegmentated[2]));
                    toBeReturned.setPreferredFoot(correctSegmentated[3].charAt(0));
                    toBeReturned.setPosition(correctSegmentated[4]);
                    toBeReturned.setPace(Integer.parseInt(correctSegmentated[5]));
                    toBeReturned.setShooting(Integer.parseInt(correctSegmentated[6]));
                    toBeReturned.setPassing(Integer.parseInt(correctSegmentated[7]));
                    toBeReturned.setDribbling(Integer.parseInt(correctSegmentated[8]));
                    toBeReturned.setDefending(Integer.parseInt(correctSegmentated[9]));
                    toBeReturned.setPhysical(Integer.parseInt(correctSegmentated[10]));
                    toBeReturned.setHeading(Integer.parseInt(correctSegmentated[11]));
                    return toBeReturned;
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "longJumper":
                LongJumper toBeReturned1 = new LongJumper();
                try {
                    toBeReturned1.setFirstName(correctSegmentated[0].split(" ")[0]);
                    toBeReturned1.setLastName(correctSegmentated[0].split(" ")[1]);
                    toBeReturned1.setHeight(Double.parseDouble(correctSegmentated[1]));
                    toBeReturned1.setWeight(Double.parseDouble(correctSegmentated[2]));
                    toBeReturned1.setPace(Integer.parseInt(correctSegmentated[3]));
                    toBeReturned1.setPhysical(Integer.parseInt(correctSegmentated[4]));
                    toBeReturned1.setJumpingHeight(Integer.parseInt(correctSegmentated[5]));
                    return toBeReturned1;
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "weightLifter":
                WeightLifter toBeReturned2 = new WeightLifter();
                try {
                    toBeReturned2.setFirstName(correctSegmentated[0].split(" ")[0]);
                    toBeReturned2.setLastName(correctSegmentated[0].split(" ")[1]);
                    toBeReturned2.setHeight(Double.parseDouble(correctSegmentated[1]));
                    toBeReturned2.setWeight(Double.parseDouble(correctSegmentated[2]));
                    toBeReturned2.setPhysical(Integer.parseInt(correctSegmentated[3]));
                    toBeReturned2.setStrength(Integer.parseInt(correctSegmentated[4]));
                    return toBeReturned2;
                } catch (Exception e) {
                    System.out.println("Oops... An error occurred, please try again");
                }
                break;
            case "sprinter":
                Sprinter toBeReturned3 = new Sprinter();
                try {
                    toBeReturned3.setFirstName(correctSegmentated[0].split(" ")[0]);
                    toBeReturned3.setLastName(correctSegmentated[0].split(" ")[1]);
                    toBeReturned3.setHeight(Double.parseDouble(correctSegmentated[1]));
                    toBeReturned3.setWeight(Double.parseDouble(correctSegmentated[2]));
                    toBeReturned3.setPace(Integer.parseInt(correctSegmentated[3]));
                    toBeReturned3.setPhysical(Integer.parseInt(correctSegmentated[4]));
                    return toBeReturned3;
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

