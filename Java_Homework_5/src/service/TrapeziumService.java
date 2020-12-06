package service;

import model.Parallelogram;
import model.Trapezium;

import java.util.Scanner;

public class TrapeziumService {
    public Trapezium create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side, the first and second bases and the height, with spaces between them (e.g. 1 3 6 5) (if you don't know the height, input -1): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double d = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.println("Enter the angle between a side and the 2nd base sides in degrees  (e.g. 30): ");
        int aa = sc.nextInt();
        if (c == -1) {
            return new Trapezium(a, b, d, aa);
        } else {
            return new Trapezium(a, b, d, c, aa);
        }

    }
}
