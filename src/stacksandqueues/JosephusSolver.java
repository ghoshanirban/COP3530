package stacksandqueues;

public class JosephusSolver {
    public static void main(String[] args) {
        int n = 10000, m = 201;

        LinkedQueue<Integer> Q = new LinkedQueue<>();

        for (int i = 1; i <= n; i++)
            Q.enqueue(i);

        while ((Q.size() > 1)) {
            for (int i = 0; i < m - 1; i++)
                Q.enqueue(Q.dequeue());

            System.out.println("Eliminating player: " + Q.dequeue() + " ");
        }

        System.out.print("Winning position: " + Q.first());
    }
}
