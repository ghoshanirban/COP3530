package analysis;

public class MemoryUsageDemo {
    public static void main(String[] args) {
        boolean[][] matrix = new boolean[10000][10000];
        System.out.println("A 10000 X 10000 matrix has been created.");

        matrix = new boolean[20000][20000];
        System.out.println("A 20000 X 20000 matrix has been created.");

        matrix = new boolean[40000][40000];
        System.out.println("A 40000 X 40000 matrix has been created.");

        matrix = new boolean[80000][80000]; // program crashes!
        System.out.println("A 80000 X 80000 matrix has been created.");
    }
}
