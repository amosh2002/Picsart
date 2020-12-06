package model;

public class Parallelogram extends Quadrilateral {
    private double h;

    public Parallelogram(double side, double base, double h, int angle_ad) {
        super(side, base, side, base, (360 - (angle_ad + angle_ad)) / 2, (360 - (angle_ad + angle_ad)) / 2, angle_ad, angle_ad);
        setH(h);
    }

    public Parallelogram(double side, double base, int angle_ad) {
        super(side, base, side, base, (360 - (angle_ad + angle_ad)) / 2, (360 - (angle_ad + angle_ad)) / 2, angle_ad, angle_ad);
        setH();
    }


    public double getH() {
        return h;
    }

    public void setH(double h) {
        if (h <= 0) {
            return;
        }
        this.h = h;
    }

    private void setH() {
        setH(Math.sin(Math.toRadians(angle_ad)) * a);
    }

    public double getSide() {
        return super.getA();
    }

    public double getBase() {
        return super.getB();
    }

    public void setSide(double side) {
        super.setA(side);
        super.setC(side);
    }

    public void setBase(double base) {
        super.setB(base);
        super.setD(base);
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public double getArea() {
        return h * b;
    }

}
