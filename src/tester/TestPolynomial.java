package tester;

import arraysandLLs.Polynomial;
import java.io.IOException;

public class TestPolynomial {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Polynomial p = new Polynomial("datasets/polyA.txt");
        System.out.println("p(x) = " + p);

        Polynomial q = new Polynomial("datasets/polyB.txt");
        System.out.println("q(x) = " + q);

        Polynomial result = Polynomial.add(p,q);
        System.out.println("result = " + result);

        result.sendToFile("datasets/result.txt");

        Polynomial zero = new Polynomial("datasets/polyZero.txt");
        System.out.println("result + Zero = " + Polynomial.add(result,zero));

        Polynomial r = new Polynomial("datasets/polyC.txt");
        System.out.println("r(x) = " + r);
        System.out.println("result + r = " + Polynomial.add(result,r));

        for( var term : result )
            System.out.println(term);
    }
}
