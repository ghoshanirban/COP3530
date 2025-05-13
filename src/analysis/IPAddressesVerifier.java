package analysis;

import java.util.*;

public class IPAddressesVerifier {
    public static String randomIPAddress() {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." +
               r.nextInt(256) + "." + r.nextInt(256);
    }

    public static String[] generateRandomIPAddresses(int n) {
        String[] addresses = new String[n];
        for(int i = 0; i < n; i++)
            addresses[i] = randomIPAddress();
        return addresses;
    }

    // Runs in O(n^2) time
    public static boolean bruteForce(String[] addresses) {
        for( int i = 0; i < addresses.length-1; i++ )
            for( int j = i+1; j < addresses.length; j++ ){
                if( i != j && addresses[i].equals(addresses[j]))
                    return false;
            }
        return true;
    }

    // Runs in O(n log n) time
    public static boolean linearithmic(String[] addresses) {
        Arrays.sort(addresses); // Takes O(n log n) time; uses the compareTo() method from the String class
        for( int i = 0; i < addresses.length - 1; i++) // this for loop runs in O(n) time
            if( addresses[i].equals(addresses[i+1]) )
                return false;
        return true;
    }

    public static void main(String[] args) {
        for(int n = 1000; n <= 128000; n *= 2) {
            System.out.printf("n : %7d,   ", n);
            String[] addresses = generateRandomIPAddresses(n);

            long start = System.currentTimeMillis();
            boolean resultOfBruteForce = bruteForce(addresses);
            System.out.printf("Brute-force: %7d", (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            boolean resultOfLinearithmic =linearithmic(addresses);
            System.out.printf("   Linearithmic: %7d\n", (System.currentTimeMillis() - start));

            if( resultOfBruteForce != resultOfLinearithmic )
                throw new RuntimeException("Issue(s) detected with the implementations.");
        }
    }
}
