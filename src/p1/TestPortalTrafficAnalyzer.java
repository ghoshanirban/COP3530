package p1; // do not delete; you may get a 0 if you do so

import java.util.Random;

public class TestPortalTrafficAnalyzer {

 static double computeSpeedUpForArray(int[] A) {

 long startA = System.currentTimeMillis();
 PortalTrafficAnalyzer.Result resultA = PortalTrafficAnalyzer.enCubedImplementation(A);
 double timeTakenForEnCubedImplementation = System.currentTimeMillis() - startA;

 long startB = System.currentTimeMillis();
 PortalTrafficAnalyzer.Result resultB = PortalTrafficAnalyzer.enSquaredImplementation(A);
 double timeTakenForEnSquaredImplementation = System.currentTimeMillis() - startB;

 if( resultA.sum != resultB.sum ) {
 System.out.println("Result from the 2 methods are: " + resultA.sum + " " + resultB.sum);
 throw new IllegalStateException("The results returned by the two implementations do not match.");
 }

 return timeTakenForEnCubedImplementation / Math.max(timeTakenForEnSquaredImplementation,1);
 }

 public static int[] generateRandomArrayOfLength(int n){
 int[] A = new int[n];
 Random generator = new Random();

 for(int i = 0; i < n; i++){
 int randomInteger = generator.nextInt(1000), randomZeroOrOne = generator.nextInt(2);
 A[i] = (randomZeroOrOne == 0) ? randomInteger : -randomInteger;
 }

 return A;
 }

 public static void main(String[] args) {

 // Sample tests for checking correctness. Create more by hand to check your code.
 int[] A1 = {-20, -40, 80, -10, 50, 90, -70, -20, 40, -30, 20};
 int[] A2 = {-20, -40, -80, -10, -50, -90, -70, -20, -40, -30, -20};
 int[] A3 = {1,1,1,1,1,1,1,1,1,1,1};

 if( PortalTrafficAnalyzer.enCubedImplementation(A1).sum != 210 ||
 PortalTrafficAnalyzer.enCubedImplementation(A1).sum != 210 ) {
 System.out.println("Testing A1: Bug(s) in your method detected.");
 }

 if( PortalTrafficAnalyzer.enCubedImplementation(A2).sum != 0 ||
 PortalTrafficAnalyzer.enCubedImplementation(A2).sum != 0 ) {
 System.out.println("Testing A2: Bug(s) in your method detected.");
 }

 if( PortalTrafficAnalyzer.enCubedImplementation(A3).sum != 11 ||
 PortalTrafficAnalyzer.enCubedImplementation(A3).sum != 11 ) {
 System.out.println("Testing A3: Bug(s) in your method detected.");
 }

 /* I got the following on my MacBook Pro (plugged in). The numbers vary a bit every time I run.
 * n = 1000, Avg. speedup: 42X
 * n = 2000, Avg. speedup: 351X
 * n = 3000, Avg. speedup: 920X
 * n = 4000, Avg. speedup: 1333X
 * n = 5000, Avg. speedup: 1509X
 * n = 6000, Avg. speedup: 1735X
 * n = 7000, Avg. speedup: 2168X
 * n = 8000, Avg. speedup: 2461X
 * n = 9000, Avg. speedup: 2651X
 * n = 10000, Avg. speedup: 3141X
 */

 int numberOfSamples = 5;
 for( int n = 1000; n <= 10000; n = n + 1000 ) {
 double avgSpeedUp = 0;
 for(int j = 0; j < numberOfSamples; j++)
 avgSpeedUp += computeSpeedUpForArray(generateRandomArrayOfLength(n));
 System.out.println("n = " + n + ", Avg. speedup: " + (int)(avgSpeedUp / numberOfSamples) + "X");
 }
 }
}
