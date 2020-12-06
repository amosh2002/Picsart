package main;

import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        Quadrilateral quadrilateral = new QuadrilateralService().create();
        quadrilateral.printNameAndArea();
        Parallelogram parallelogram = new ParallelogramService().create();
        parallelogram.printNameAndArea();
        Rectangle rectangle = new RectangleService().create();
        rectangle.printNameAndArea();
        Square square = new SquareService().create();
        square.printNameAndArea();
        Trapezium trapezium = new TrapeziumService().create();
        trapezium.printNameAndArea();
        System.out.println(trapezium.compareTo(rectangle));
    }
}
