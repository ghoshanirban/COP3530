package recursion;

import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JFrame {
    public static int OFFSET = 50; // pixel offset from edge
    final private int depth; // recursion depth
    
    public SierpinskiTriangle(int depth) {
        super("Sierpinski triangle");
    	this.depth = depth;
        setSize(1000, 1000);
        setVisible(true);
    }
    
    @Override 
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        Point p1 = new Point(getWidth() / 2, OFFSET);
        Point p2 = new Point(OFFSET, getHeight() - OFFSET);
        Point p3 = new Point(getWidth() - OFFSET, getHeight() - OFFSET);            
        drawTriangles(g, depth, p1, p2, p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /** = the midpoint between p1 and p2 */
    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
    
    /** Draw a Sierpinski triangle of depth d with perimeter
      * given by p1, p2, p3.
        p1-p2 is the base-line, p3 the top point*/
    private static void drawTriangles(Graphics g, int d, Point p1, Point p2, Point p3) {
        if (d == 0) {  // depth is 0, draw the triangle

            // set a random color
            g.setColor(new Color((int)(Math.random() * 0x1000000)));

            Polygon P = new Polygon();
            P.addPoint(p1.x,p1.y);
            P.addPoint(p2.x,p2.y);
            P.addPoint(p3.x,p3.y);

            g.fillPolygon(P);
            return;
        }
        // Draw three Sierpinski triangles of depth d-1
        Point m12 = midpoint(p1,p2);
        Point m23 = midpoint(p2,p3);
        Point m31 = midpoint(p3,p1);

        drawTriangles(g, d - 1, p1, m12, m31);
        drawTriangles(g, d - 1, m12, p2, m23);
        drawTriangles(g, d - 1, m31, m23, p3);
    }

    public static void main(String[] args) {
    	new SierpinskiTriangle(3);
    }
}
