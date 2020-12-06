package model;

public class Square extends Quadrilateral{
    public Square(double a) {
        super(a, a, a, a, 90, 90, 90, 90);
    }

    @Override
    public double getPerimeter() {
        return 4 * a;
    }

    @Override
    public double getArea() {
        return Math.pow(a, 2);
    }

    public double getAngle(){
        return 90;
    }

}
