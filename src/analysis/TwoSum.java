package analysis;

import java.util.*;

public class TwoSum {
    public static int[] generateRandomArray(int n){
        Random generator = new Random();
        int[] array = new int[n];
        for( int i = 0; i < n; i++)
            array[i] = generator.nextInt(n);
        return array;
    }

    public static boolean bruteForce(int[] A, int x) {
        for(int i = 0; i < A.length - 1; i++)
            for( int j = i + 1; j < A.length; j++)
                if( A[i] + A[j] == x )
                    return true;
        return false;
    }

    public static boolean linearithmic(int[] A, int x) {
        Arrays.sort(A);

        int left = 0, right = A.length-1;

        while( left < right )
            if (A[left] + A[right] > x) // sum is larger; decrement right
                right--;
            else if (A[left] + A[right] < x)  // sum is less; increment left
                left++;
            else // A[left] + A[right] == x; success!
                return true;

        return false;
    }

    public static void main(String[] args) {
        for(int n = 1000; n <= 512000; n *= 2) {
            System.out.printf("n : %7d,   ", n);

            int[] A = generateRandomArray(n);
            Random r = new Random();
            int x = r.nextInt();

            long start = System.currentTimeMillis();
            boolean resultOfBruteForce = bruteForce(A, x);
            System.out.printf("Brute-force: %7d", (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            boolean resultOfLinearithmic = linearithmic(A, x);
            System.out.printf("   Linearithmic: %7d\n", (System.currentTimeMillis() - start));

            if( resultOfBruteForce != resultOfLinearithmic )
                throw new RuntimeException("Issues detected with the implementations.");
        }
    }
}
