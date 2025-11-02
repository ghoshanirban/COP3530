package trees;

import java.io.*;
import java.util.*;

public class Trie implements Iterable<String> { // This code works only on English words
                                                // made up of letters only.
    private static class TrieNode { // The node class for the Trie
        String word = null;
        TrieNode parent = null;
        TrieNode[] children = new TrieNode[26]; // every cell contains a 'null'
    }

    private final TrieNode root = new TrieNode(); // root must always be present
    private int numberOfWords = 0;
    public  Trie() { }

    public int numberOfWords( ){ return numberOfWords; }

    // loads words from a text file (assumption: every line contains a single word)
    public void loadWordsFromFile(String str) throws FileNotFoundException {
        Scanner input = new Scanner(new File(str));
        while( input.hasNextLine() )
            insertNewWord( input.nextLine() );
        input.close();
    }

    // puts all the words currently stored in the trie inside an ArrayList
    public void getAllWords( ArrayList<String> words) { getAllWordsRec(root,words); }

    // a recursive helper method for getAllWords() method
    private void getAllWordsRec(TrieNode node, ArrayList<String> words) {
        if( node == null )  return;
        if( node.word != null )  words.add( node.word );
        for(int i = 0; i < node.children.length; i++) // recursively traverse all the children
            if( node.children[i] != null )
                getAllWordsRec(node.children[i], words);
    }

    // Using a string, it traces out a path in the trie and
    // returns a reference to the last visited node in the traced path
    // if 's' is absent in the trie, insert it by creating additional nodes
    private TrieNode traverseUsingString(String s) {
        s = s.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i < s.length() ; i++) {
            int childID = s.charAt(i) - 'a';
            if( current.children[childID] == null )
                current.children[childID] = new TrieNode();
            current.children[childID].parent = current;
            current = current.children[childID];

        }
        return current; // returns the reference to the last visited node
    }

    // checks if a trie node is a leaf
    private boolean isLeaf(TrieNode node) {
        for( int i = 0; i < node.children.length; i++ )
            if( node.children[i] != null )
                return false;
        return true;
    }

    // get the child id
    private int getChildID(TrieNode parent, TrieNode child) {
        for( int i = 0; i < parent.children.length; i++ )
            if( parent.children[i] == child )
                return i;
        return -1;
    }

    // inserts a new word in the trie
    public void insertNewWord(String s) {
        for(int i = 0; i < s.length(); i++) // check if every character is an English letter or not
            if( !Character.isLetter(s.charAt(i)) )
                throw new IllegalArgumentException("Every character in the string must be a letter.");

        TrieNode lastNode = traverseUsingString(s);
        if( lastNode.word == null) {
            lastNode.word = s;
            numberOfWords++;
        }
    }

    // removes a word from the trie
    public void removeWord(String s) {
        s = s.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i < s.length() ; i++) { // climb down the tree
            int childID = s.charAt(i) - 'a'; // get the id of the child
            if( current.children[childID] == null )
                return;
            current = current.children[childID];
        }
        if( current.word != null ) { // delete the word is present
            current.word = null;
            numberOfWords--;
        }

        while ( current != root && isLeaf(current)  ){ // climb up and keep on deleting useless nodes

            // check if current has more than one child
            int numberOfChildren = 0;
            for( TrieNode child : current.children ) {
                if (child != null)
                    numberOfChildren++;
                if (numberOfChildren > 1)
                    break;
            }

            if( current.word != null || numberOfChildren > 1 )
                break;
            TrieNode parentOfCurrent = current.parent;
            parentOfCurrent.children[ getChildID(parentOfCurrent,current) ] = null;
            current = parentOfCurrent;
        }
    }

    // checks if a string is present in the trie
    public boolean isPresent(String s) {
        TrieNode lastNode = traverseUsingString(s);
        return lastNode.word != null;
    }

    // finds the words which have the same prefix s
    public void wordsHavingPrefix(String prefix, ArrayList<String> words){
        TrieNode lastNode = traverseUsingString(prefix);
        getAllWordsRec(lastNode,words); // grab all the words in the subtree rooted at 'lastNode'
    }

    // counts the total number of nodes in the tree including the root
    public int numberOfNodes() {
        return numberOfNodesRec(root);
    }

    // a helper method for the numberOfNodes() method
    private int numberOfNodesRec(TrieNode node){
        if( isLeaf( node) ) // return 1 is the node is a leaf
            return 1;

        int nodeCount = 1; // count the current node
        for (int i = 0; i < node.children.length; i++) // spawn a recursive call for every child
            if (node.children[i] != null)
                nodeCount += numberOfNodesRec( node.children[i] );
        return nodeCount;
    }


    // returns an iterator for the trie;
    // downside of this approach: requires additional space
    public Iterator<String> iterator() {
        ArrayList<String> allWords = new ArrayList<>(); // additional space used
        getAllWords(allWords); // grab all the words in the trie
        return allWords.iterator(); // return an ArrayList iterator
    }
}
