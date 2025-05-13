package ood;

import java.util.Iterator;

//using the Iterable interface; basically a wrapper class for the String class
public class IterableString implements Iterable<Character>{ // The iterator will iterate over
                                                            // a sequence of characters
    String str;
    public IterableString(String str) {
        this.str = str;
    }

    public Character getCharAt(int position) {
        return str.charAt(position);
    }

    public int length() {
        return str.length();
    }

    // other string methods

    public Iterator<Character> iterator() {
        return new IterableStringIterator(this);
    }

    // using the Iterator interface
    public static class IterableStringIterator implements Iterator<Character> {
        int position;
        IterableString s;

        public IterableStringIterator(IterableString s) {
            this.s = s;
            position = 0;
        }

        // returns false if position has already past the
        // last character in the string
        public boolean hasNext() {
            return position < s.length();
        }

        // returns the character at the current position and
        // then increments position to the next character
        public Character next() {
            Character c = s.getCharAt(position);
            position++;
            return c;
        }
    }

    public String toString(){
        return str;
    }
}
