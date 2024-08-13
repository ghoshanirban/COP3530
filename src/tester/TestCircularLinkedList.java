package tester;

import arraysandLLs.CircularLinkedList;

public class TestCircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList<String> runningPrograms = new CircularLinkedList<>();

        runningPrograms.addLast("Antivirus");
        runningPrograms.addLast("VLC-Player");
        runningPrograms.addLast("Browser");
        runningPrograms.addLast("Email-client");

        for(var e : runningPrograms)
            System.out.print(e + " ");

        runningPrograms.addFirst("IntelliJ");

        System.out.println();

        for(var e : runningPrograms)
            System.out.print(e + " ");

        runningPrograms.rotate();

        System.out.println();

        for(var e : runningPrograms)
            System.out.print(e + " ");

        System.out.println("\nFirst: " + runningPrograms.first());
        System.out.println("Last: " + runningPrograms.last());
        System.out.println("Size: " + runningPrograms.size());

        String s = runningPrograms.removeFirst();
        System.out.println("Removed: " + s);

        for(var e : runningPrograms)
            System.out.print(e + " ");
    }
}
