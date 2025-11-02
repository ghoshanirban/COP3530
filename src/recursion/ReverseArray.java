package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void reverseArray(int[] A, int i, int j) {
        System.out.println("Executing reverseArray(A," + i + "," + j + ")");

        if (i > j)
            throw new IllegalArgumentException("i <= j is required.");

        int hold = A[i];
        A[i] = A[j];
        A[j] = hold;

        if( i + 1 < j - 1 )
              reverseArray(A, i + 1, j - 1); // recursive call
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        //System.out.println(Arrays.toString(arr));
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
