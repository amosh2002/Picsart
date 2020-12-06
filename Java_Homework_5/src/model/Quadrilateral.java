package model;

public class Quadrilateral extends Shape implements Describable, Comparable<Quadrilateral> {
    protected double d;
    protected int angle_ab, angle_cd, angle_ad, angle_bc;

    public Quadrilateral(double a, double b, double c, double d, int angle_ab, int angle_cd, int angle_ad, int angle_bc) {
        super(a, b, c);
        setD(d);
        this.angle_ad = angle_ad;
        this.angle_ab = angle_ab;
        this.angle_cd = angle_cd;
        this.angle_bc = angle_bc;
        if (areAnglesOk()) {
            setAngle_ab(angle_ab);
            setAngle_cd(angle_cd);
            setAngle_ad(angle_ad);
            setAngle_bc(angle_bc);
        } else {
            setAllAnglesTo0();
        }

    }

    private void setAllAnglesTo0() {
        this.angle_ad = 0;
        this.angle_ab = 0;
        this.angle_cd = 0;
        this.angle_bc = 0;
    }

    private boolean areAnglesOk() {
        return angle_cd + angle_ab + angle_ad + angle_bc == (double) 360;
    }


    public double getD() {
        return d;
    }

    public void setD(double d) {
        if (d < 0) {
            return;
        }
        this.d = d;
    }

    public int getAngle_ab() {
        return angle_ab;
    }

    public void setAngle_ab(int angle_ab) {
        if (angle_ab < 0 || angle_ab >= 180 && areAnglesOk()) {
            return;
        }
        this.angle_ab = angle_ab;
    }

    public int getAngle_cd() {
        return angle_cd;
    }

    public void setAngle_cd(int angle_cd) {
        if (angle_cd < 0 || angle_cd >= 180 && areAnglesOk()) {
            return;
        }
        this.angle_cd = angle_cd;
    }

    public int getAngle_ad() {
        return angle_ad;
    }

    public void setAngle_ad(int angle_ad) {
        if (angle_ad < 0 || angle_ad >= 180 && areAnglesOk()) {
            return;
        }
        this.angle_ad = angle_ad;
    }

    public int getAngle_bc() {
        return angle_bc;
    }

    public void setAngle_bc(int angle_bc) {
        if (angle_bc < 0 || angle_bc >= 180 && areAnglesOk()) {
            return;
        }
        this.angle_bc = angle_bc;
    }

    @Override
    protected void countPerimeter() {
        super.countPerimeter();
        super.perimeter += d;
    }

    @Override
    public void countArea() {
        double p = getPerimeter() / 2;
        double l = (double) (angle_ab + angle_cd) / 2;
        super.area = Math.sqrt((p - a) * (p - b) * (p - c) * (p - d) - a * b * c * d * Math.pow(Math.toRadians(Math.cos(l)), 2));
    }

    @Override
    public void printNameAndArea() {
        System.out.printf("%s with area of %s\n", this.getClass().getSimpleName(), getArea());
    }

    @Override
    public void printName() {
        System.out.printf("%s\n", this.getClass().getSimpleName());
    }

    @Override
    public void printArea() {
        System.out.printf("%s\n", this.getArea());
    }

    @Override
    public void printPerimeter() {
        System.out.printf("%s\n", this.getPerimeter());
    }

    @Override
    public int compareTo(Quadrilateral o) {
        return (int) (this.getArea() - o.getArea());
    }
}
