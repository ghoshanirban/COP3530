package maps;

import java.io.*;

public class WordCounter {
	TreeMapBST<String,Integer> T = new TreeMapBST<>();
		
	public WordCounter(String fileName) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(fileName));
	
		String line;
				
    	while ((line = input.readLine()) != null) {  
			 StringBuilder s = new StringBuilder();
			 for(int i = 0; i < line.length(); i++) {		 
				 if( Character.isLetter( line.charAt(i) ) )
					 s.append( Character.toLowerCase( line.charAt(i) ) );
				 else {
					 if(!s.isEmpty())
						 add(s.toString());
					 s.setLength(0);
				 }
			 }
		 }
		input.close();
	}

	public int getuniqueWordsCount() {
		return T.size();
	}
	
	private void add(String w) {
		Integer currentCount = T.get(w);
		if( currentCount == null ) T.put(w, 1);
		else T.updateValue(w,currentCount+1);
	}

	public Integer countOccurrenceOf(String w) {
		Integer count = T.get(w);
		return ( count == null ) ? 0 : count;
	}

	public void getWordFrequenciesSortedLexicographically() {
		for( var record : T )
			System.out.println("<" + record.getKey() + ", " + record.getValue() + ">");
	}
}
