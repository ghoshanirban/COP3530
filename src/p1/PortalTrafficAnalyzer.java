package p1; // do not delete; you may get a 0 if you do so

public class PortalTrafficAnalyzer {
    // A nested class for handling the results returned by the implementations
	// Do not touch this class. 
    public static class Result {
        public final int sum, leftIndex, rightIndex;

        public Result(int first, int second, int third){
            this.sum = first;
            this.leftIndex = second;
            this.rightIndex = third;
        }

        public String toString() {
            return "<" + sum + ", " + leftIndex + ", " + rightIndex + ">";
        }
    }
	
	// Returns the maximum sum, left index of the max. subarray, and the right index of the subarray
    public static Result enCubedImplementation(int[] A){
        int maxSum = 0, leftIndex = 0, rightIndex = 0; // dummy values; feel free to change the values

        // complete

        return new Result(maxSum,leftIndex,rightIndex);
    }

	// Returns the maximum sum, left index of the max. subarray, and the right index of the subarray
    public static Result enSquaredImplementation(int[] A){
        int maxSum = 0, leftIndex = 0, rightIndex = 0; // dummy values; feel free to change the values

        // complete
       
        return new Result(maxSum,leftIndex,rightIndex);
    }
}
