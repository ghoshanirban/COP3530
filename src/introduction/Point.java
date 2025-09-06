package introduction;

public class Point {

    public static Integer pointsCreated = 0; // a class-wide common variable
    Double x, y; // instance variables

    public static final Point ORIGIN = new Point(0.0, 0.0); // a constant public Point object,

    // the object can be modified but not
    // the reference variable
    public Point(Double x, Double y) { // a constructor
        this.x = x;
        this.y = y;        // 'this' refers to the object being considered currently
        pointsCreated++;
    }

    public Point(Point p){ // a copy constructor (this object is made an identical copy of another Point object)
        this.x = p.x;
        this.y = p.y;
        pointsCreated++;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Double distance(Point p, Point q) { // an object is not needed to call this
        Double t1 = Math.pow((p.getX() - q.getX()), 2), t2 = Math.pow((p.getY() - q.getY()), 2);
        return Math.sqrt(t1 + t2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) // check if obj is actually a reference to a Point object
            return Double.compare(this.x, ((Point) obj).x) == 0 && Double.compare(this.y, ((Point) obj).y) == 0;
        else
            return false;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}