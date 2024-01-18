package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    public int compareTo(Home another) {
        if (another instanceof Cottage) {
            double anotherArea = ((Cottage) another).getArea();
            if (area > anotherArea) {
                return 1;
            } else if (area < anotherArea) {
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
