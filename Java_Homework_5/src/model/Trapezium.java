package model;

public class Trapezium extends Quadrilateral {
    private double h;

    public Trapezium(double side, double base1, double base2, double h, int angle_ad) {
        super(side, base1, side, base2, (360 - (angle_ad + angle_ad)) / 2, (360 - (angle_ad + angle_ad)) / 2, angle_ad, angle_ad);
        setH(h);
    }

    public Trapezium(double side, double base1, double base2, int angle_ad) {
        super(side, base1, side, base2, (360 - (angle_ad + angle_ad)) / 2, (360 - (angle_ad + angle_ad)) / 2, angle_ad, angle_ad);
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

    @Override
    public double getPerimeter() {
        return 2 * (b + a);
    }

    @Override
    public double getArea() {
        return (b + d) / 2 * h;
    }

}
