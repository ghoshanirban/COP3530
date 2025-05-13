package recursion;

import java.util.Arrays;

public class MergeSort {
	public static <K extends Comparable<K>> void sort(K[] S) {
		if( S.length < 2) // nothing to do; just return
			return;

		K[] S1 =  Arrays.copyOfRange(S, 0, S.length/2 );  // copy the elements from 0 to S.length/2 - 1 to S1
		K[] S2 =  Arrays.copyOfRange(S, S.length/2, S.length ); // copy the elements from S.length/2 to S.length - 1 to S1

		sort( S1 ); // recursively sort S1
		sort( S2 ); // recursively sort S2

		merge(S1, S2, S); // merge S1, S2 into S
	}

	private static <K extends Comparable<K>> void merge(K[] leftSequence, K[] rightSequence, K[] outputSequence) {
		int i = 0; // index into leftSequence
		int j = 0; // index into rightSequence
		int k = 0; // index into outputSequence

		// while there are items left in both the sequences (leftSequence and rightSequence)
		while ( i < leftSequence.length && j < rightSequence.length )  {
			// send the min(leftSequence[i], rightSequence[j]) to the outputSequence (if they are equal, send rightSequence[j])
			if( leftSequence[i].compareTo(rightSequence[j]) < 0 )
				outputSequence[k++] = leftSequence[i++];  // the item is the leftSequence is smaller
			else
				outputSequence[k++] = rightSequence[j++]; // otherwise send the item from the rightSequence
		}

		// send the remaining elements in the leftSequence to the outputSequence
		while( i < leftSequence.length )
			outputSequence[k++] = leftSequence[i++];

		// send the remaining elements in the rightSequence to the outputSequence
		while( j < rightSequence.length )
			outputSequence[k++] = rightSequence[j++];
	}
}
