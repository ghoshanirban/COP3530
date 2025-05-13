package recursion;

import introduction.Point;

import java.util.ArrayList;

public class Subsets {
    public static void findSubsetsRec(ArrayList<Object> chosen, ArrayList<Object> deciding) {
        if( deciding.isEmpty() ) {
            System.out.print("{ ");
            for (var i : chosen)
                System.out.print(i + " ");
            System.out.println( "}");
            return;
        }

        ArrayList<Object> chosenBackUp = new ArrayList<>(chosen);
        Object considering = deciding.remove ( deciding.size()-1 );
        ArrayList<Object> decidingBackUp = new ArrayList<>(deciding);
        chosenBackUp.add( considering );

        findSubsetsRec( chosen, deciding ); // without the first element from deciding
        findSubsetsRec( chosenBackUp, decidingBackUp ); // with the first element from deciding
    }

    public static void findSubsets( ArrayList<Object> items ){
        ArrayList<Object> deciding = new ArrayList<>();
        findSubsetsRec(deciding,items);
    }

    public static void main(String[] args) {
        ArrayList<Object> items = new ArrayList<>();
        items.add(10);
        items.add(20);
        items.add(30);




//        ArrayList<Object> items = new ArrayList<>();
//        items.add("Aaron");
//        items.add(66);
//        items.add(true);
//        items.add(new Point(3.55,88.4));

//        for (int i = 1; i <= n; i++)
//            deciding.add(i);
        findSubsets(items);
//
//        int n = 100;
//        for(int i = 0; i < n ; i++ ) {
//            long start = System.currentTimeMillis();
//            ArrayList<Integer> deciding = new ArrayList<>();
//            for (int j = 0; j < i; j++)
//                deciding.add(j);
//            ArrayList<Integer> chosen = new ArrayList<>();
//            findSubsets(chosen, deciding);
//            System.out.println( "i: " + i + " " + (System.currentTimeMillis() - start));
//        }
    }
}