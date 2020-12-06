package service;

import model.Parallelogram;
import model.Quadrilateral;

import java.util.Scanner;

public class ParallelogramService {
    public Parallelogram create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 sides and the height, with spaces between them (e.g. 1 3 5) (if you don't know the height, input -1): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.println("Enter the angle between those 2 sides in degrees  (e.g. 30): ");
        int aa = sc.nextInt();
        if (c == -1) {
            return new Parallelogram(a, b, aa);
        } else {
            return new Parallelogram(a, b, c, aa);
        }

    }
}
