package model;

public class Rectangle extends Quadrilateral implements Idealizable {
    public Rectangle(double a, double b) {
        super(a, b, a, b, 90, 90, 90, 90);
    }

    @Override
    public double getPerimeter() {
        return 2 * (b + a);
    }

    @Override
    public double getArea() {
        return a * b;
    }

    public double getAngle() {
        return 90;
    }

    @Override
    public void idealize() {
        setA(a);
        setB(a);
        setC(a);
        setC(a);
    }
    
}
