package service;

import model.Square;

import java.util.Scanner;

public class SquareService {
    public Square create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side (e.g. 1): ");
        double a = sc.nextDouble();
        return new Square(a);
    }
}
