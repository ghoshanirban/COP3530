package tester;

import stacksandqueues.LinkedDeque;

public class TestLinkedDeque {
    public static void main(String[] args) {
        LinkedDeque<String> studentDeque = new LinkedDeque<>();
        studentDeque.addLast("Bob");
        studentDeque.addLast("Tina");
        studentDeque.addLast("Pat");
        studentDeque.addLast("Alice");
        studentDeque.addLast("John");

        studentDeque.addFirst("Tom");

        studentDeque.removeLast();
        studentDeque.removeFirst();

        for( var student : studentDeque )
            System.out.print(student + " ");
    }
}
