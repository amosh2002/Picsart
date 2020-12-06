package service;

import model.Rectangle;

import java.util.Scanner;

public class RectangleService {
    public Rectangle create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 sides, with spaces between them (e.g. 1 3): ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        return new Rectangle(a, b);
    }
}
