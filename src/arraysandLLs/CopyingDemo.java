package arraysandLLs;

import introduction.Point;
import java.util.Arrays;

public class CopyingDemo {
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////////////
//        System.out.println("Situation 1");
//        int[] sourceArrayA = {10,20,30,40,50};
//        int[] destinationArrayA = sourceArrayA; // shallow-copy; just copying references
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayA ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayA ) );
//
//        for(int index = 0; index < sourceArrayA.length; index++)
//            sourceArrayA[index] /= 10;
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayA ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayA ) );
        /////////////////////////////////////////////////////////////////////////////////
//        System.out.println("========================================");
        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("Situation 2");
//        int[] sourceArrayB = {50,60,70,80,90,100};
//        int[] destinationArrayB = new int[sourceArrayB.length];
//
//        for(int index = 0; index < sourceArrayB.length; index++) // deep-copy; copying stuff to the destination array
//            destinationArrayB[index] = sourceArrayB[index];
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayB ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayB ) );
//
//        for(int index = 0; index < sourceArrayB.length; index++)
//            sourceArrayB[index] /= 10;
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayB ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayB ) );
//        /////////////////////////////////////////////////////////////////////////////
//        System.out.println("========================================");
//        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("Situation 3");
//        int[] sourceArrayC = {11,21,31,41,51};
//        int[] destinationArrayC = sourceArrayC.clone(); // deep-copy
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayC ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayC ) );
//
//        for(int index = 0; index < sourceArrayC.length; index++)
//            sourceArrayC[index] *= 10;
//
//        System.out.println( "Source array: " + Arrays.toString( sourceArrayC ) );
//        System.out.println( "Destination array: " + Arrays.toString( destinationArrayC ) );
//        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("========================================");
//        ///////////////////////////////////////////////////////////////////////////////
        System.out.println("Situation 4");
        Point[] sourcePointArrayA = {new Point(1.0,2.0), new Point(3.0, 4.0), new Point(5.0, 6.0)};
        Point[] destinationPointArrayA = sourcePointArrayA; // shallow-copy

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayA ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayA ) );

        sourcePointArrayA[0].setX(99.123);
        sourcePointArrayA[1].setY(-45.6899);

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayA ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayA ) );
//        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("========================================");
//        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("Situation 5");
        Point[] sourcePointArrayB = {new Point(11.0,21.0), new Point(31.0, 41.0), new Point(51.0, 61.0)};
        Point[] destinationPointArrayB = sourcePointArrayB.clone(); // shallow-copy for non-primitives

        // The following approach is doing shallow-copy too!
        //Point[] destinationPointArrayB = new Point[sourcePointArrayB.length];
        //System.arraycopy(sourcePointArrayB,0, destinationPointArrayB,0,3);

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayB ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayB ) );

        sourcePointArrayB[0].setX(101.11);
        sourcePointArrayB[1].setY(211.771);

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayB ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayB ) );
//        ///////////////////////////////////////////////////////////////////////////////
//        System.out.println("========================================");
//        ///////////////////////////////////////////////////////////////////////////////
        System.out.println("Situation 6");
        Point[] sourcePointArrayC = {new Point(1.1,2.1), new Point(3.1, 4.1), new Point(5.1,6.1)};

        // doing deep-copy
        Point[] destinationPointArrayC = new Point[sourcePointArrayC.length]; // objects are not created as of now!
        for(int index = 0; index < destinationPointArrayC.length; index++ ) // now we create objects and initialize them
            destinationPointArrayC[index] = new Point(sourcePointArrayC[index]);
                    //new Point(sourcePointArrayC[index].getX(),sourcePointArrayC[index].getY());

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayC ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayC ) );

        sourcePointArrayC[0].setX(101.11);
        sourcePointArrayC[1].setY(211.771);

        System.out.println( "Source point array: " + Arrays.toString( sourcePointArrayC ) );
        System.out.println( "Destination point array: " + Arrays.toString( destinationPointArrayC ) );

//        int n = 10;
//        Point[] anArrayOfPoints = new Point[n];
//        //double x = anArrayOfPoints[5].getX(); <---- throws NullPointerException
//        for(int i = 0; i < anArrayOfPoints.length; i++)
//            anArrayOfPoints[i] = new Point(Math.random() * 10, Math.random() * 10);

    }
}
