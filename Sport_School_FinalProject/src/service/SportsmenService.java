package service;

import java.io.IOException;
import java.util.Arrays;

public class SportsmenService {
    public static void printFootballerByName(String[] array) throws IOException {
        String[] infos = FileService.read("C:\\Users\\Armen Armenakyan\\OneDrive\\Desktop\\Picsart-master\\Sport_School_FinalProject\\src\\database\\sportsmen.txt");
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

        System.out.println(Arrays.toString(correctLine));
    }
}
