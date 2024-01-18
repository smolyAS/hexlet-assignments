package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    public double getTotalArea() {
        return area + balconyArea;
    }

    public String toString() {
        return "Квартира площадью " + getTotalArea() + " метров на " + floor + " этаже";
    }

    public int compareTo(Home another) {
        if (another instanceof Flat) {
            double anotherTotalArea = ((Flat) another).getTotalArea();
            if (getTotalArea() > anotherTotalArea) {
                return 1;
            } else if (getTotalArea() < anotherTotalArea) {
                return -1;
            } else {
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Invalid argument type");
        }
    }
}
// END
