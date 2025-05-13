package tester;
import introduction.Counter;

public class TestCounter {
    public static void main(String[] args) {
        Counter c1;         // declares a reference variable
        c1 = new Counter(); // now c1 points to a Counter object

        System.out.println(c1);

        System.out.println("Value after creating c1: " + c1.getValue());

        c1.increment();
        System.out.println("Value after c1.increment(): " + c1.getValue());

        c1.incrementBy(10);
        System.out.println("Value after c1.increment(10): " + c1.getValue());

        c1.changeValueTo(0);
        System.out.println("Value after c1.reset(): " + c1.getValue());

        c1.incrementBy(-99); // decrementing using the same increment method!
        System.out.println("Value after c1.increment(-99): " + c1.getValue());

        Counter c2 = new Counter(100), c3 = new Counter(200);
        System.out.println("Sum of c2 and c3: " + (c2.getValue() + c3.getValue()));
    }
}
