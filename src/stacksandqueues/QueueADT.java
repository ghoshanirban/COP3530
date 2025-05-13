package stacksandqueues;

public interface QueueADT<E> {
	void enqueue(E e);
	E dequeue();
	int size();
	boolean isEmpty();
	E first();
}
