package tester;

public class ComparablePoint implements Comparable<ComparablePoint>{
    double x,y; // instance variables

    public ComparablePoint(double x, double y) { // a constructor
        this.x = x;	this.y = y;        // 'this' refers to the object being considered currently
    }

    public String toString() { return "(" + x + ", " + y + ")"; }

    // lexicographic comparison
    @Override
    public int compareTo(ComparablePoint p) {
        if( this.x < p.x || (this.x == p.x && this.y < p.y))  return -1;
        else if ( this.x == p.x && this.y == p.y)             return 0;
        else                                                  return 1;
    }
}