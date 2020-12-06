package service;

import model.Quadrilateral;

import java.util.Scanner;

public class QuadrilateralService {
    public Quadrilateral create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 4 sides, with spaces between them (e.g. 1 3 5 2): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        System.out.println("Enter the 4 angles in degrees, with spaces between them (e.g. 30 60 120 150): ");
        int aa = sc.nextInt();
        int bb = sc.nextInt();
        int cc = sc.nextInt();
        int dd = sc.nextInt();
        return new Quadrilateral(a, b, c, d, aa, bb, cc, dd);

    }
}
