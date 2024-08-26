package introduction;

public class Counter {
    private int count;  // a simple integer instance variable

    public Counter() { // default constructor (count is 0)
        System.out.println("The default constructor is called.");
    }
    public Counter(int init) {  // an alternate constructor
        count = init;
        System.out.println("The alternate constructor is called.");
    }
    public int getValue() { return count; }                       // an accessor method
    public void increment() { count++; }                     	  // an update method
    public void incrementBy(int delta) { count += delta; }        // an update method
    public void changeValueTo(int newValue) { count = newValue; } // an update method

    public String toString() {
        System.out.println("The toString() from Counter class is invoked");
        return Integer.toString(count);
    }
}
