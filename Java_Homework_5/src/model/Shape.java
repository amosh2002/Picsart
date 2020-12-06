package model;

public abstract class Shape {
    protected double a, b, c;
    protected double area;
    protected double perimeter;

    public Shape(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
        countArea();
        countPerimeter();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea() {
        return area;
    }

    protected abstract void countArea();

    public double getPerimeter() {
        return perimeter;
    }

    protected void countPerimeter() {
        this.perimeter = a + b + c;
    }
}
