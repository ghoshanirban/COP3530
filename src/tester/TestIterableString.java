package tester;

import ood.IterableString;

import java.util.Iterator;

public class TestIterableString {
    public static void main(String[] args) {
        // The following does not get compiled since for-each loop does not work on Strings
//         String x = "Data Structures";
//         for(Character s : x)
//              System.out.print(s);

        // The following works but str2.toCharArray() creates an unnecessary array and wastes space
//        String y = "Data Structures";
//        for(Character s : y.toCharArray())
//            System.out.print(s);

        // Space-optimized approach and works seamlessly
//        IterableString z = new IterableString("Data Structures");
//        System.out.println(z);
//        System.out.println("Size: " + z.length() );
//        for( Character c : z )
//            System.out.print(c + " ");

       //  Same approach using the keyword 'var'
        var z = new IterableString("Data Structures");
        //System.out.println(z);
        //System.out.println("Size: " + z.length() );
        for( var c : z )
            System.out.print(c);

//        Iterator<Character> it = z.iterator();
//        while(it.hasNext())
//            System.out.print(it.next());

        // Built-in support: use String-Builder
    }
}
