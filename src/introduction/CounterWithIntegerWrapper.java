package introduction;

public class CounterWithIntegerWrapper {
	private Integer count = 0;  // a simple integer instance variable

	public CounterWithIntegerWrapper() { // default constructor (count is 0)
		System.out.println("The default constructor is called.");
	}                                 
	public CounterWithIntegerWrapper(Integer init) {  // an alternate constructor
		count = init; 
		System.out.println("The alternate constructor is called.");
	}
	public Integer getValue() { return count; }                       // an accessor method
	public void increment() { count++; }                     	  // an update method
	public void incrementBy(Integer delta) { count += delta; }          // an update method
	public void changeValueTo(Integer newValue) { count = newValue; } // an update method                  
}