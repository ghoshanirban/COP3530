package arraysandLLs;

import java.io.*;
import java.util.*;
//
public class Polynomial implements Cloneable, Iterable<Polynomial.PolynomialTerm> { // The cloneable interface helps to create clones of an object
    /**
     *  A record class for representing the polynomial terms.
     *  Record classes are used for designing simple classes - no need to write constructors
     *  and getter/setter methods, and even the toString method. Those come with record classes for free!
     */
    public record PolynomialTerm(int coefficient, int exponent) { }
    SinglyLinkedList<PolynomialTerm> L = new SinglyLinkedList<>(); // A singly linked list to represent the polynomial

    private Polynomial() { } // creates and empty polynomial; used internally (is declared private)

    /**
     * This method reads a polynomial from a text file and creates a polynomial linked list
     * @param inputFilePath The first line of the file stores the number of terms in the polynomial.
     *                      The remaining lines hold the polynomial terms, one per line.
     *                      Every line contain two items: coefficient and exponent,
     *                      separated by a single space. The terms are stored left to right,
     *                      starting with the term with the highest power. Coefficients and exponents
     *                      are assumed to be integers.
     */
    public Polynomial(String inputFilePath){
        try {
            File fileObject = new File(inputFilePath);
            Scanner fileInput = new Scanner(fileObject);
            int numberOfTerms = Integer.parseInt( fileInput.nextLine() );

            for(int i = 0; i < numberOfTerms; i++) {
                String[] items = fileInput.nextLine().split(" ");
                int coefficient = Integer.parseInt(items[0]), exponent = Integer.parseInt(items[1]);
                L.addLast(new PolynomialTerm(coefficient, exponent));
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.print("The input file cannot be detected. Aborting!");
        }
    }

    @Override
    public Polynomial clone() throws CloneNotSupportedException {
        // https://docs.oracle.com/en/java/javase/17/docs//api/java.base/java/lang/Cloneable.html
        var clonePolynomial = (Polynomial) super.clone();
        clonePolynomial.L = new SinglyLinkedList<>();
        for (var term : L) // create identical terms in the clone
            clonePolynomial.L.addLast(new PolynomialTerm(term.coefficient, term.exponent));
        return clonePolynomial;
    }

    private boolean isZeroPolynomial() { // checks if 'p' is a zero polynomial (p(x)=0)
        return L.size() == 1 && L.first().coefficient == 0 && L.first().exponent == 1;
    }

    public static Polynomial add(Polynomial p, Polynomial q) throws CloneNotSupportedException {
        if( p.isZeroPolynomial() ) // if 'p' is a zero polynomial, then p + q = q
            return q.clone();      // return a clone of 'q'

        if( q.isZeroPolynomial() ) // if 'q' is a zero polynomial, then p + q = p
            return p.clone();      // return a clone of 'p'

        Polynomial result = new Polynomial(); // create a new empty polynomial
        Iterator<PolynomialTerm> itForPolynomialP = p.L.iterator(), itForPolynomialQ = q.L.iterator();
        PolynomialTerm nextTermFromP = itForPolynomialP.next(), nextTermFromQ = itForPolynomialQ.next();

        while( nextTermFromP != null && nextTermFromQ != null ){ // while there are un-scanned polynomial terms in both the polynomials
           if( nextTermFromP.exponent == nextTermFromQ.exponent ) { // the exponents match, so add up the coefficients
               var nextTermForResult = new PolynomialTerm( nextTermFromP.coefficient + nextTermFromQ.coefficient, nextTermFromP.exponent);
               result.L.addLast(nextTermForResult); //  add to the term result polynomial
               nextTermFromP = ( itForPolynomialP.hasNext() ) ? itForPolynomialP.next() : null;
               nextTermFromQ = ( itForPolynomialQ.hasNext() ) ? itForPolynomialQ.next() : null;
           }
           else if( nextTermFromP.exponent > nextTermFromQ.exponent ) { // send the current term from 'p' to the result
               var nextTermForResult = new PolynomialTerm( nextTermFromP.coefficient, nextTermFromP.exponent );
               result.L.addLast(nextTermForResult); //  add to the term result polynomial
               nextTermFromP = ( itForPolynomialP.hasNext() ) ? itForPolynomialP.next() : null;
           }
           else { // send the current term from 'q' to the result
               var nextTermForResult = new PolynomialTerm( nextTermFromQ.coefficient, nextTermFromQ.exponent );
               result.L.addLast(nextTermForResult); //  add to the term result polynomial
               nextTermFromQ = ( itForPolynomialQ.hasNext() ) ? itForPolynomialQ.next() : null;
           }
        }

        if( itForPolynomialP.hasNext() ) // if polynomial p has un-scanned elements send them to the result
            while( itForPolynomialP.hasNext() )
                result.L.addLast( itForPolynomialP.next() );

        if( itForPolynomialQ.hasNext() ) // if polynomial q has un-scanned elements send them to the result
            while( itForPolynomialQ.hasNext() )
                result.L.addLast( itForPolynomialQ.next() );

        return result;
    }

    // Writes a polynomial to a text file
    public void sendToFile( String outputFilePath ) throws IOException {
        FileWriter fileOutput = new FileWriter(outputFilePath);
        fileOutput.write(L.size() + "\n" );

        for( var term : L )
            fileOutput.write(term.coefficient + " " + term.exponent + "\n");

        fileOutput.close();
    }

    public String toString(){
        StringBuilder str = new StringBuilder();

        var it = L.iterator();

        while(it.hasNext()) {
            var term = it.next();
            str.append(term.coefficient);
            if( term.exponent == 0 )
                break;
            if(term.exponent == 1 )
                str.append("x");
            else {
                str.append("x^");
                str.append(term.exponent);
            }
            if( it.hasNext() )
                str.append(" + ");
        }

        return str.toString();
    }

    @Override
    public Iterator<PolynomialTerm> iterator() {
        return L.iterator(); // reusing the iterator from the SinglyLinkedList class
    }
}
