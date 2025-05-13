package tester;

import arraysandLLs.COP3530ArrayList;
import introduction.Point;

import java.util.Random;

public class TestCOP3530ArrayList {
    public static void main(String[] args) {
        COP3530ArrayList<Integer> intA = new COP3530ArrayList<>();
        for(int i = 10; i <= 100; i += 10)
            intA.add(i);
        System.out.println(intA);

        intA.remove(5);
        System.out.println(intA);

        intA.insert(5,29);
        System.out.println(intA);

        COP3530ArrayList<Point> P = new COP3530ArrayList<>();
        P.add(new Point(1.0,2.0));
        P.add(new Point(3.33,4.35));
        System.out.println(P);

        intA.remove(intA.size()-1);
        System.out.println(intA);

        for(int n = 10; n < 100000000; n *= 10) {
            System.out.print(n + " ");
            COP3530ArrayList<Integer> A = new COP3530ArrayList<>();
            Random r = new Random();

            int count = 0;
            for (int i = 0; i < n; i++)
                if (A.add(r.nextInt(10)))
                    count++;

            System.out.println(count);
        }
    }
}
