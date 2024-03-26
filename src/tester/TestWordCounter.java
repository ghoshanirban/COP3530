package tester;

import maps.WordCounter;

import java.io.IOException;

public class TestWordCounter {
	public static void main(String[] args) throws IOException {
		WordCounter wc = new WordCounter("datasets/oz.txt");
		System.out.println("Unique words count: " + wc.getuniqueWordsCount());
		System.out.println("==============================");
		wc.getWordFrequenciesSortedLexicographically();
		System.out.println("==============================");
		System.out.println(wc.countOccurrenceOf("dorothy"));
		System.out.println(wc.countOccurrenceOf("stack"));
	}
}
