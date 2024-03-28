package tester;

import maps.TreeMapRBTree;

public class TestTreeMapRBTree {
    public static void main(String[] args) {
        TreeMapRBTree<Integer,String> T = new TreeMapRBTree<>();

        T.turnOnCaseTracing();

        T.put(41, "Eric");
        T.put(38, "Pat");
        T.put(31, "Caroline");
        T.put(12, "Tom");
        T.put(19, "Ann");
        T.put(8, "Jennifer");

        for(var record : T )
            System.out.println(record.getKey() + ", " + record.getValue());



        System.out.println();
        T.printInOrderTraversal();
        System.out.println("\nHeight: " + T.height());

        T.updateValue(38,"Anne");

        T.clear() ;
    }
}
